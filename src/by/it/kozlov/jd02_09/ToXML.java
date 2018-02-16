package by.it.kozlov.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class ToXML {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("C:/Users/skynet/IdeaProjects/JD2017-12-16/src/by/it/kozlov/jd02_09/Persons XSD.xml")))) {
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Persons persons = (Persons) unmarshaller.unmarshal(reader);
            String text = persons.toString();
            System.out.println(text.replace("{", "\n").replace("}", "\n"));
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(persons, new File("C:/Users/skynet/IdeaProjects/JD2017-12-16/src/by/it/kozlov/jd02_09/Persons2.xml"));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
