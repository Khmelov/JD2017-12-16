package by.it.vshelukhin.jd02_09.TaskA;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Runner {
    public static void main(String[] args) {
        String passXML = "E:/Java/JD2017-12-16/src/by/it/vshelukhin/jd02_09/TaskA/Students.xml";
        String passXSL = "E:/Java/JD2017-12-16/src/by/it/vshelukhin/jd02_09/TaskA/trans.xsl";
        String passHTML = "E:/Java/JD2017-12-16/src/by/it/vshelukhin/jd02_09/TaskA/Students.html";

        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(passXSL));
            transformer.transform(new StreamSource(passXML),new StreamResult(passHTML));
            System.out.println("Преобразование XML в HTML завершено!");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
