package by.it.krasutski.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlProcess {

    private static final String path = System.getProperty("user.dir") + "/src/by/it/krasutski/jd02_09/Users+XSD.xml";
    private static final String output = System.getProperty("user.dir") + "/src/by/it/krasutski/jd02_09/Users+JAXB.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users)unmarshaller.unmarshal(new File(path));
            System.out.println(users);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(users,new File(output));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
