package Lab5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


class DirTree extends TreeFrame {

    private static String directory;
    private static Document doc;
    private static Map<DefaultMutableTreeNode, Element> map = new HashMap<>();

    DirTree( ){
        super();

    }

    void initTree() {
        root = new DefaultMutableTreeNode(directory);
        treeModel = new DefaultTreeModel( root );
        tree = new JTree( treeModel );
        tree.setBackground(Color.green);
        buildTree();
    }


    public static void main(String[] args) {
        if(args.length>0) directory=args[0];
        else directory= ("Liv.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //Defines a factory API that enables
        // applications to obtain a parser that produces DOM object trees from XML documents.
        // Obtain a new instance of a DocumentBuilderFactory.
        try {
            DocumentBuilder builder = factory.newDocumentBuilder(); //Defines the API to obtain DOM Document instances
            // from an XML document. Using this class, an application programmer can obtain a Document from XML.
            // Using newDocumentBuilder XML can be parsed from a variety of input sources.
            doc = builder.parse(directory);
            // Parse the content of the given file as an XML document and return a new DOM Document object.

            Element element = (Element) doc.getFirstChild();
            directory = element.getAttribute("namn");
            new DirTree();
        }

        catch (ParserConfigurationException e){
            System.out.println(1);
        }
        catch (SAXException e){
            System.out.println("Fel i xml taggar");
        }
        catch (IOException e) {
            System.out.println("Filen stämmer inte");
        }

    }

    private void buildTree(){

        Element element = (Element) doc.getFirstChild();
        //System.out.println(element +"       " + root);
        map.put(root, element);
        buildTree(element, root);

    }

    private void buildTree(Element e, DefaultMutableTreeNode parent){

        NodeList nodeList = e.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node n = nodeList.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) n;
                String s = element.getAttribute("namn");
                DefaultMutableTreeNode child = new DefaultMutableTreeNode(s);
                parent.add(child);
                map.put(child, element);

                buildTree(element, child);

            }
        }
    }

    void showDetails(TreePath p){
        if ( p == null )
            return;

        DefaultMutableTreeNode node = (DefaultMutableTreeNode)p.getLastPathComponent();

        Element element = map.get(node);
        String text = element.getTagName() + ": " + p.getLastPathComponent().toString() +
                element.getFirstChild().getTextContent();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Men allt som är " + node);

        while (node.getParent()!=null){
            stringBuilder.append(" är " + node.getParent());
            node = (DefaultMutableTreeNode)node.getParent();
        }

        JOptionPane.showMessageDialog( this, text + "\n" + stringBuilder);

    }
}


class TreeFrame extends JFrame implements ActionListener {
    JCheckBox box;
    JTree tree;
    DefaultMutableTreeNode root;
    DefaultTreeModel treeModel;
    JPanel controls;
    static final String closeString = " Close ";
    static final String showString = " Show Details ";

    TreeFrame() {
        Container c = getContentPane();

        // initTree() should create root, treeModel and tree.
        initTree();

        tree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (box.isSelected())
                    showDetails(tree.getPathForLocation(e.getX(),
                            e.getY()));
            }
        });

        controls = new JPanel();
        box = new JCheckBox(showString);
        initGUI();
        c.add(controls, BorderLayout.NORTH);
        c.add(tree, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals(closeString))
            dispose();
    }

    void initGUI() {
        tree.setFont(new Font("Dialog", Font.BOLD, 12));
        controls.add(box);
        addButton(closeString);
        controls.setBackground(Color.lightGray);
        controls.setLayout(new FlowLayout());
        setSize(400, 400);
    }

    void addButton(String n) {
        JButton b = new JButton(n);
        b.setFont(new Font("Dialog", Font.BOLD, 12));
        b.addActionListener(this);
        controls.add(b);
    }

    // ***** Override initTree in subclass
    // ***** create root, treeModel and tree in the new initTree
    void initTree(){
        root = new DefaultMutableTreeNode("TestString");
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
    }

    // ***** showDetails can also be overridden in a subclass *****
    void showDetails(TreePath path){
        if (path == null)
            return;
        String info = path.getLastPathComponent().toString();
        JOptionPane.showMessageDialog(this, info);
    }

    public static void main(String[] u) {
        new TreeFrame();
    }

}
