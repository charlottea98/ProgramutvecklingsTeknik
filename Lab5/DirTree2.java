package Lab5;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

class DirTree2 extends TreeFrame2 {

    static String directory=".";

    // Overrides method in TreeFrame
    void initTree() {
        root = new DefaultMutableTreeNode(directory);
        treeModel = new DefaultTreeModel( root );
        tree = new JTree( treeModel );
        buildTree();
    }

    // New method
    private void buildTree() {

        File f=new File(directory);
        String[] list = f.list();
        for (int i=0; i<list.length; i++ ) {
            System.out.println(list[i]);
            buildTree(new File(f, list[i]), root);
        }
    }

    // New method
    private void buildTree( File f, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode child =
                new DefaultMutableTreeNode( f.toString() );
        parent.add(child);

        if ( f.isDirectory() ) {
            String list[] = f.list();
            for ( int i = 0; i < list.length; i++ )
                buildTree( new File(f,list[i]), child);
        }
    }

    // Overrides method in TreeFrame
    void showDetails(TreePath p){
        if ( p == null )
            return;
        File f = new File( p.getLastPathComponent().toString() );
        JOptionPane.showMessageDialog( this, f.getPath() +
                "\n   " +
                getAttributes( f ) );
    }

    // New method
    private String getAttributes( File f ) {
        String t = "";
        if ( f.isDirectory() )
            t += "Directory";
        else
            t += "Nondirectory file";
        t += "\n   ";
        if ( !f.canRead() )
            t += "not ";
        t += "Readable\n   ";
        if ( !f.canWrite() )
            t += "not ";
        t += "Writeable\n  ";
        if ( !f.isDirectory() )
            t += "Size in bytes: " + f.length() + "\n   ";
        else {
            t += "Contains files: \n     ";
            String[ ] contents = f.list();
            for ( int i = 0; i < contents.length; i++ )
                t += contents[ i ] + ", ";
            t += "\n";
        }
        return t;
    }

    public static void main(String[] args) {
        if(args.length>0) directory=args[0];
        new DirTree2();
    }

}


class TreeFrame2 extends JFrame implements ActionListener {
    JCheckBox box;
    JTree tree;
    DefaultMutableTreeNode root;
    DefaultTreeModel treeModel;
    JPanel controls;
    static final String closeString = " Close ";
    static final String showString = " Show Details ";

    TreeFrame2() {
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
        new TreeFrame2();
    }
}