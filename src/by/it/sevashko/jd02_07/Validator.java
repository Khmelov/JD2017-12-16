package by.it.sevashko.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Validator {

    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String xsdPath = "src/by/it/sevashko/jd02_07/Users.xsd";
        String xmlFile = "src/by/it/sevashko/jd02_07/Users+XSD.xml";
        File xsdFile = new File(xsdPath);
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            Schema schema = factory.newSchema(xsdFile);
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            System.out.println(xmlFile + " валиден");
        } catch (SAXException e) {
            System.err.print("Валидация " + xmlFile + " не выполена: "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.print(xmlFile + " не валиден:"
                    + e.getMessage());
        }
    }
}
