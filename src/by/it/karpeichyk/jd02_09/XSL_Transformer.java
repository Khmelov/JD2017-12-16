package by.it.karpeichyk.jd02_09;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by user on 16.02.2018.
 */
public class XSL_Transformer {
    private final static String root= "src/by/it/karpeichyk/jd02_09/";
    public static void main(String[] args) {
        String fileName = root+"PersonsplusDTD.xml";
        String fileHTML = root+"person.html";
        try{
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(root+"person.xsl"));
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(System.out));

            System.out.println("Transform" + fileName +"complete");
        }catch (TransformerException e){
            System.err.println("Impossible transform file" + fileName+ " : " + e);
        }

    }
}
