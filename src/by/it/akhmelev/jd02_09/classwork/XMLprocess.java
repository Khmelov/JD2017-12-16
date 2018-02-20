package by.it.akhmelev.jd02_09.classwork;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLprocess {

    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/akhmelev/jd02_09/classwork/Persons+XSD.xml";
        String out = root + "/src/by/it/akhmelev/jd02_09/classwork/Persons_OUT.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Persons persons = (Persons)unmarshaller.unmarshal(new File(path));
            System.out.println(persons);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(persons,new File(out));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
