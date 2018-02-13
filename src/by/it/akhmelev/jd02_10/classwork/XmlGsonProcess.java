package by.it.akhmelev.jd02_10.classwork;

import by.it.akhmelev.jd02_09.classwork.Persons;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XmlGsonProcess {

    private final static String PathXML =System.getProperty("user.dir")+"/src/by/it/akhmelev/jd02_09/classwork/Persons+XSD.xml";
    private final static String ResultXml =System.getProperty("user.dir")+"/src/by/it/akhmelev/jd02_09/classwork/Persons2.xml";
    private final static String PathJson =System.getProperty("user.dir")+"/src/by/it/akhmelev/jd02_10/classwork/Persons.json";

    public static void main(String[] args) throws Exception{
            JAXBContext context=JAXBContext.newInstance(Persons.class);
            Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();

            //read XML
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Persons persons=(Persons)unmarshaller.unmarshal(new File(PathXML));
            System.out.println(persons);
            //save json
            String json = gson.toJson(persons);
            BufferedWriter w=new BufferedWriter(new FileWriter(PathJson));
            w.write(json);
            w.close();

            //read json
            StringBuilder sb=new StringBuilder();
            BufferedReader r=new BufferedReader(new FileReader(PathJson));
            String line;
            while (!(line = r.readLine()).isEmpty())
                sb.append(line).append("\n");
            r.close();
            Persons p2=gson.fromJson(sb.toString(), Persons.class);
            System.out.println(p2);

            //save xml
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(p2,new File(ResultXml));
    }
}
