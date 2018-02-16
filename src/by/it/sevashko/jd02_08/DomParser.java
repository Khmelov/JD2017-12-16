package by.it.sevashko.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParser {

    public static void main(String[] args) {
        String xmlFile = String.format("%s%S", System.getProperty("user.dir"), "/src/by/it/sevashko/jd02_08/Users.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDocument = builder.parse(xmlFile);
            Node rootElement = xmlDocument.getDocumentElement();
            printNode("", rootElement);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }

    private static void printNode(String indent, Node node){
        //начало тега и аттрибуты
        System.out.printf("%s[%s", indent, node.getNodeName());
        if (node.hasAttributes()) {
            NamedNodeMap attrs = node.getAttributes();
            for (int i = 0; i < attrs.getLength(); i++) {
                Node attr = attrs.item(i);
                    String name = attr.getNodeName();
                    String value = attr.getTextContent();
                    System.out.printf(" %s=%s", name, value);

            }
        }
        System.out.println(']');
        //вывод вложееных тегов
        if (node.hasChildNodes()) {
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE) printNode(indent + '\t', child);
                if (child.getNodeType() == Node.TEXT_NODE){
                    String text = child.getTextContent().trim();
                    if (!text.equals("")) System.out.printf("%s\t%s\n", indent, text);
                }
            }
        }
        //конец тега
        System.out.printf("%s[/%s]\n", indent, node.getNodeName());
    }
}
