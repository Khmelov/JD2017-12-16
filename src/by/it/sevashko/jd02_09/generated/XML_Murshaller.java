package by.it.sevashko.jd02_09.generated;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XML_Murshaller {

    private final static String path=System.getProperty("user.dir")+"/src/by/it/sevashko/jd02_09/generated/Users+XSD.xml";
    private final static String path2=System.getProperty("user.dir")+"/src/by/it/sevashko/jd02_09/generated/Users_OUT.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context=JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users Users=(Users)unmarshaller.unmarshal(new File(path));
            System.out.println(Users);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(Users,new File(path2));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
