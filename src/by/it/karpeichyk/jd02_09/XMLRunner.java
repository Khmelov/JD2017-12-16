package by.it.karpeichyk.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by user on 16.02.2018.
 */
public class XMLRunner {
    private  final static  String path = System.getProperty("user.dir")+"/src/by/it/karpeichyk/jd02_09/PersonsplusXSD.xml";
    private  final static  String path2 = System.getProperty("user.dir")+"/src/by/it/karpeichyk/jd02_09/Personsnew.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Persons persons=(Persons)unmarshaller.unmarshal(new File(path));
            System.out.println(persons);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(persons,new File(path2));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        }
    }


