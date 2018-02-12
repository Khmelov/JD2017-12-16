package by.it.kozlov.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOM {
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
            System.out.println(prefix + text.trim());
        }

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDOM(prefix + node.getNodeName() + ">", children.item(i));
        }
    }
}
