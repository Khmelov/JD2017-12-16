package by.it.kozlov.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ToXML {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Persons persons = (Persons) unmarshaller.unmarshal(new File("C:/Users/skynet/IdeaProjects/JD2017-12-16/src/by/it/kozlov/jd02_09/Persons2.xml"));
            System.out.println(persons);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(persons, new File("C:/Users/skynet/IdeaProjects/JD2017-12-16/src/by/it/kozlov/jd02_09/Persons3.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
