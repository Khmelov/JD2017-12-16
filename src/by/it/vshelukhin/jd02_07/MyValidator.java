package by.it.vshelukhin.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class MyValidator {
    public static void main(String[] args) {
        System.out.println("XML на тему онлайн магазина контрольных работ для студентов-заочников\n");
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileXML = "E:\\Java\\JD2017-12-16\\src\\by\\it\\vshelukhin\\jd02_07\\Students+xsd.xml";
        String fileShema = "E:\\Java\\JD2017-12-16\\src\\by\\it\\vshelukhin\\jd02_07\\Students.xsd";
        SchemaFactory shFac = SchemaFactory.newInstance(lang);
        File fShema = new File(fileShema);

        try {
            Schema schema = shFac.newSchema(fShema);
            Validator validator = schema.newValidator();
            Source sourceFile = new StreamSource(fileXML);
            validator.validate(sourceFile);
            System.out.println("Файл "+fileXML+" валиден!");

        } catch (SAXException | IOException e) {
            System.out.println("Файл "+fileXML+" не валиден!");
            e.printStackTrace();
        }
    }
}