package by.it.karpeichyk.jd02_10;

import by.it.karpeichyk.jd02_09.Persons;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by user on 28.02.2018.
 */
public class XmlGSONProcess {
    public  final  static  String PathXML = System.getProperty("user.dir") + "/src/by/it/karpeichyk/jd02_10/PersonsplusXSD.xml";
    public  final  static  String ResultXML = System.getProperty("user.dir") + "/src/by/it/karpeichyk/jd02_10/Persons2.xml";
    public  final  static  String PathJson = System.getProperty("user.dir") + "/src/by/it/karpeichyk/jd02_10/Persons.json";

    public static void main(String[] args) throws Exception {

        JAXBContext context = JAXBContext.newInstance(Persons.class);
        Gson gson = new  GsonBuilder().serializeNulls().setPrettyPrinting().create();

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Persons persons = (Persons) unmarshaller.unmarshal(new File(PathXML));
        System.out.println(persons);

        String json = gson.toJson(persons);
        BufferedWriter writer = new BufferedWriter(new FileWriter(PathJson));
        writer.write(json);
        writer.close();

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(PathJson));
        String line;
        while(!(line=reader.readLine()).isEmpty())
            sb.append(line).append("\n");
        reader.close();
        Persons p2 = gson.fromJson(sb.toString(), Persons.class);
        System.out.println(p2);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(p2,new File(ResultXML));
    }
}
