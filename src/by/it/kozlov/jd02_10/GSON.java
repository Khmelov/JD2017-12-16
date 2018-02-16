package by.it.kozlov.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.*;
import java.io.*;

public class GSON {
    public static void main(String[] args) {
        Persons persons = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Persons.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir")+"/src/by/it/kozlov/jd02_09/Persons XSD.xml")))) {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            persons = (Persons) unmarshaller.unmarshal(reader);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

        String json = gson.toJson(persons);
        try (BufferedWriter writer=new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir")+"/src/by/it/kozlov/jd02_10/Persons.json")))) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Persons persons2 = gson.fromJson(json, Persons.class);
        System.out.println("persons2=" + persons2.toString());


        try {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(persons2, new File(System.getProperty("user.dir")+"/src/by/it/kozlov/jd02_10/Persons2.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
