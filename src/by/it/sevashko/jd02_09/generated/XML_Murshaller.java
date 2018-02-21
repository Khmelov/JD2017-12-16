package by.it.sevashko.jd02_09.generated;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XML_Murshaller {

    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String in = root + "/src/by/it/sevashko/jd02_09/generated/Users+XSD.xml";
        String out = root + "/src/by/it/sevashko/jd02_09/generated/Users_OUT.xml";
        try {
            JAXBContext context=JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users Users=(Users)unmarshaller.unmarshal(new File(in));
            System.out.println(Users);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(Users,new File(out));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
