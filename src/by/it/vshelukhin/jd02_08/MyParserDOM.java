package by.it.vshelukhin.jd02_08;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class MyParserDOM {

    static String tab = "";

    static String pass = "E:/Java/JD2017-12-16/src/by/it/vshelukhin/jd02_08/Students.xsd";

    public static void main(String[] args) {
        try {
            File f = new File(pass);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = factory.newDocumentBuilder();
            Document doc = parser.parse(f);
            Element kornevojElement = doc.getDocumentElement();
            printDOM(kornevojElement);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    static void printDOM(Node el){
        System.out.printf("%s{%s",tab,el.getNodeName());
        NamedNodeMap atr = el.getAttributes();
        if (atr != null){
            for (int i = atr.getLength()-1; i >= 0; i--) {
                System.out.printf(" %s",atr.item(i).toString());
            }
        }
        System.out.printf("}\n");
        if (el.getNodeValue() != null) System.out.println(el.getNodeValue().trim());
        NodeList child = el.getChildNodes();
        tab = tab + "\t";
        for (int i = 0; i < child.getLength(); i++) {
            if (child.item(i).getNodeName().matches("#.+")) continue;
            printDOM(child.item(i));
        }
        tab = tab.substring(1);
        System.out.printf("%s{/%s}\n",tab,el.getNodeName());
    }
}
