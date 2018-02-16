//--add-modules java.se.ee

package by.it.kozlov.jd02_10.converter;

import by.it.kozlov.jd02_10.Persons;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Persons.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "/src/by/it/kozlov/jd02_09/Persons XSD.xml")))) {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Persons persons = (Persons) unmarshaller.unmarshal(reader);
            AbstractConverter converter = ConverterFactory.convert(1);
            converter.convert(persons);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
