package by.it.sendetskaya.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOM {

    private static String tab="";
    private static StringBuilder text = new StringBuilder();
    private final static String filePath = "src/by/it/sendetskaya/jd02_07/Shop+XSD.xml";

    public static void main(String[] args) {

        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.parse(filePath);
            Element el=document.getDocumentElement();
            printAttributs(el);
            printDom(tab,el);
        } catch (ParserConfigurationException |SAXException |IOException e) {
            e.printStackTrace();
        }
    }

    private static void printAttributs(Element el) {
        NamedNodeMap text=el.getAttributes();
        if(text!=null)
        {
            for (int i = 0; i < text.getLength(); i++) {
                System.out.print(text.item(i)+" ");
            }
            System.out.println();
        }
    }

    private static void printDom(String tab, Node el) {
        String text=el.getNodeValue();
        if(text!=null)
        {
            System.out.println(tab+text.trim());
        }

        NodeList children=el.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(tab+el.getNodeName()+" > ",children.item(i));
        }
    }
}
