package by.it.patsko.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomBooks {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/by/it/patsko/jd02_08";
        String fileName = "Books.xml";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(path, fileName));
            Element element = document.getDocumentElement();
            printDom("", element);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printDom(String tab, Node node) {

            String text = node.getNodeValue();
            if(text!=null&&text.trim().equals(""))return;
            if(text==null) {
                System.out.print(
                        tab + "<" + node.getNodeName()
                );

                if (node.hasAttributes()) {
                    NamedNodeMap attr = node.getAttributes();
                    for (int i = 0; i < attr.getLength(); i++) {
                        System.out.print(" " + attr.item(i));
                    }
                }
                System.out.print(">");
            }
            System.out.println(text != null ? tab + text.trim() : "");
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                printDom(tab + "\t", children.item(i));
            }
            if(text==null)
            System.out.println(tab + "</" + node.getNodeName() + ">");
        }
    }

