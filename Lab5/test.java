package Lab5;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

class test {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse("/Users/charlotteandersson/IdeaProjects/Prutten/src/Lab5/Liv.xml");

            Node node = doc.getFirstChild();
            Element element = (Element) doc.getFirstChild();
            System.out.println(element.getAttribute("namn"));

            NodeList list = doc.getElementsByTagName("Rike");

            for (int i = 0; i < list.getLength(); i++) {
                Node p = list.item(i);
                if (p.getNodeType()==Node.ELEMENT_NODE){
                    org.w3c.dom.Element rike = (org.w3c.dom.Element) p;
                    String namn = rike.getAttribute("namn");
                }
            }

        }
        catch (ParserConfigurationException e){
            System.out.println(1);

        }
        catch (SAXException e){
            System.out.println(2);

        }
        catch (IOException e){
            System.out.println(3);
        }

    }
}
