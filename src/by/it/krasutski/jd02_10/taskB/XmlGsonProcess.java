package by.it.krasutski.jd02_10.taskB;

import by.it.krasutski.jd02_09.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XmlGsonProcess {

    private final static String PathXML = System.getProperty("user.dir") + "/src/by/it/krasutski/jd02_09/Users+XSD.xml";
    private final static String ResultXml = System.getProperty("user.dir") + "/src/by/it/krasutski/jd02_10/taskB/Users.xml";
    private final static String PathJson = System.getProperty("user.dir") + "/src/by/it/krasutski/jd02_10/taskB/Users.json";

    public static void main(String[] args) throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            //read XML
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(PathXML));
            //save JSON
            String json = gson.toJson(users);
            BufferedWriter bw = new BufferedWriter(new FileWriter(PathJson));
            bw.write(json);
            bw.close();
            //read JSON
            Users newUsers = gson.fromJson(json, Users.class);
            //save new XML
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(newUsers, new File(ResultXml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
