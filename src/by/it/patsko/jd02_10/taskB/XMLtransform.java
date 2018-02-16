package by.it.patsko.jd02_10.taskB;

import by.it.patsko.jd02_09.Catalog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XMLtransform {
    private final static String InitFile =System.getProperty("user.dir")+"/src/by/it/patsko/jd02_10/taskB/Books.xml";
    private final static String ResultFile =System.getProperty("user.dir")+"/src/by/it/patsko/jd02_10/taskB/Books2.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context=JAXBContext.newInstance(Catalog.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Catalog initCatalog = (Catalog) unmarshaller.unmarshal(new File(InitFile));
            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String json = gson.toJson(initCatalog);
            System.out.println(json);
            System.out.println("============================================================");

            Catalog resultCatalog = gson.fromJson(json, Catalog.class);
            System.out.println(resultCatalog);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(resultCatalog,new File(ResultFile));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
