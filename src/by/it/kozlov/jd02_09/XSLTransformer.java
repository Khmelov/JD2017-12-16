package by.it.kozlov.jd02_09;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransformer {
    private static final String path = System.getProperty("user.dir")+"/src/by/it/kozlov/jd02_09/";

    public static void main(String[] args) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(path + "Persons.xsl"));
            transformer.transform(new StreamSource(path + "Persons.xml"), new StreamResult(path + "Persons.html"));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
