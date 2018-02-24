package by.it.sevashko.jd02_10.taskB;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.*;
import java.io.File;

public class Translator {

    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String inXML = root + "/src/by/it/sevashko/jd02_10/taskB/Users.xml";
        String outXml = root + "/src/by/it/sevashko/jd02_10/taskB/RebornUser.xml";

        //XML to Class instance
        Users users = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            users = (Users) unmarshaller.unmarshal(new File(inXML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        GsonBuilder builder = new GsonBuilder();
        builder = builder.serializeNulls();
        builder = builder.setPrettyPrinting();
        Gson gson=builder.create();

        //Class instance to JSON
        String json = gson.toJson(users);
        System.out.println(json);

        //JSON to Class instance
        Users newUsers = gson.fromJson(json, Users.class);
        System.out.println(newUsers);

        try {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(newUsers, new File(outXml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
