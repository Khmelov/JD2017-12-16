package by.it.kozlov.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidXSD {
    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String file = "src/by/it/kozlov/jd02_07/Persons XSD.xml";
        String schemaName = "src/by/it/kozlov/jd02_07/Persons.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaFile = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(file);
            validator.validate(source);
            System.out.println(file + " валиден");
        } catch (SAXException e) {
            System.err.println("Валидация " + file + " не выполнена");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(file + " не валиден");
            e.printStackTrace();
        }
    }
}
