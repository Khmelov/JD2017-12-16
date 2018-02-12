package by.it.viktorbrui.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DOM {
    public static void main(String[] args) {
        String fileName = "src/by/it/viktorbrui/jd02_07/Project/Shop+XSD.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc=builder.parse(fileName);
            Element el=doc.getDocumentElement();
            printDom("", el);
        } catch (Exception e) {
            System.out.print("Exeption!!! " + e.toString());
        }
    }

    private static void printDom(String prefix, Node node) {
        String text= node.getNodeValue();
        if (text!=null){
            System.out.println(prefix + text.trim());
        }
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(prefix+node.getNodeName()+ " > ", children.item(i));
        }
    }
}
