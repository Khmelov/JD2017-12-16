package by.it.kozlov.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOM {
    private static String buffer = "";

    public static void main(String[] args) {
        String path = "src/by/it/kozlov/jd02_07/Persons XSD.xml";

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(path);
            Element element = document.getDocumentElement();
            printDOM("", element);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printDOM(String prefix, Node node) {
        String text = node.getNodeValue();

        if (text != null) {
            text = text.trim().replace("\n", "");
            if (text.length() > 0) {
                System.out.print(prefix + text.trim() + "\n");
            }

        }

        NodeList children = node.getChildNodes();
        if (children.getLength() > 0) {
            System.out.print(prefix + "[" + node.getNodeName());
            NamedNodeMap nodeMap = node.getAttributes();
            for (int i = 0; i < nodeMap.getLength(); i++) {
                System.out.print(" " + nodeMap.item(i));
            }
            System.out.println("]");
            prefix = prefix + "\t";
        }

        for (int i = 0; i < children.getLength(); i++) {

            buffer = node.getNodeName();

            printDOM(prefix, children.item(i));
        }
        if (children.getLength() > 0) {
            prefix = prefix.substring(1);
            System.out.println(prefix + "[/" + node.getNodeName() + "]");
        }
    }
}
