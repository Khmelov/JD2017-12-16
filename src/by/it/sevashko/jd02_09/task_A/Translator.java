package by.it.sevashko.jd02_09.task_A;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Translator {

    private final static String src = "src/by/it/sevashko/jd02_09/task_A/";

    public static void main(String[] args) {
        String xmlName = src + "Users.xml";
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(src + "Subscriptions.xsl"));
            transformer.transform(new StreamSource(xmlName), new StreamResult(src + "Subscriptions.html"));
            System.out.println("Transform " + xmlName + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + xmlName + " : " + e);
        }
    }
}
