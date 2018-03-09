package by.it.sevashko.jd02_10.taskC;

import by.it.sevashko.jd02_10.taskB.Users;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;

public class Runner {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            //json to xml
            System.out.println("----- Json to XML -----\n");
            AbstractConverter<Users> converterToXML = ConverterFactory.createConverter(Direction.JSON_TO_XML, Users.class);
            System.out.println(converterToXML.convert(new File(System.getProperty("user.dir") + "/src/by/it/sevashko/jd02_10/taskC/Users.json")));
            converterToXML.convert(System.getProperty("user.dir") + "/src/by/it/sevashko/jd02_10/taskC/Users.json");

            //xml to json
            System.out.println("\n----- XML to JSON -----\n");
            AbstractConverter<Users> converterToJSON = ConverterFactory.createConverter(Direction.XML_TO_JSON, Users.class);
            System.out.println(converterToJSON.convert(new File(System.getProperty("user.dir") + "/src/by/it/sevashko/jd02_10/taskC/Users.xml")));
            converterToJSON.convert(System.getProperty("user.dir") + "/src/by/it/sevashko/jd02_10/taskC/Users.xml");
        } catch (NoSuchMethodException | JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
