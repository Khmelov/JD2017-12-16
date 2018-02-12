package by.it.krasutski.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOM {

    private final static String filepath = "src/by/it/krasutski/jd02_07/Users+XSD.xml";

    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(filepath);
            Element element = document.getDocumentElement();
            printDOM("", element);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printNode(String tab, Node node) {
        NodeList childNodes = node.getChildNodes();
        if (childNodes.getLength() > 0) {
            System.out.print(tab + "<" + node.getNodeName());
            NamedNodeMap namedNodeMap = node.getAttributes();
            for (int i = 0; i < namedNodeMap.getLength(); i++) {
                System.out.print(" " + namedNodeMap.item(i));
            }
            System.out.println(">");
            tab += "\t";
        }
        for (int i = 0; i < childNodes.getLength(); i++) {
            printDOM(tab, childNodes.item(i));
        }
        if (childNodes.getLength() > 0) {
            tab = tab.substring(1);
            System.out.println(tab + "</" + node.getNodeName() + ">");
        }
    }

    private static void printDOM(String tab, Node node) {
        String content = node.getNodeValue();
        if (content != null) {
            content = content.trim().replace("\n", "");
            if (content.length() > 0) {
                System.out.print(tab + content.trim() + "\n");
            }
        }
        printNode(tab,node);
    }
}

