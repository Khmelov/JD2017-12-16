package by.it.patsko.jd02_07.TaskC;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class ValidTaskC {
    public static void main(String[] args) {
        String fileName = "src/by/it/patsko/jd02_07/TaskC/Books+XSD.xml";
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaLocation = new File("src/by/it/patsko/jd02_07/TaskC/Books.xsd");
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(fileName));
            System.out.println(fileName + " валиден.");
        } catch (SAXException e) {
            System.err.print("Валидация " + fileName + " не выполена: "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.print(fileName + " не валиден:"
                    + e.getMessage());
        }
    }
}