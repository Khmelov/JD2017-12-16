package by.it.patsko.jd02_10.taskC;


import by.it.patsko.jd02_10.Catalog;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;

public class Runner {
    public static void main(String[] args) {
        try {
            System.out.println("======================XMLfile to text======================");
            AbstractConverter XMLfileTotextConverter=
                    ConverterFactory.createConverter(Direction.XML_TO_JSON, Catalog.class);
            System.out.println(XMLfileTotextConverter.convert(new File(System.getProperty("user.dir")+"/src/by/it/patsko/jd02_10/Books.xml")));

            System.out.println("======================XMLfile to JSONFile======================");
            AbstractConverter XMLfileToJSONfileConverter=
                    ConverterFactory.createConverter(Direction.XML_TO_JSON,Catalog.class);
            XMLfileToJSONfileConverter.convert(System.getProperty("user.dir")+"/src/by/it/patsko/jd02_10/Books.xml");

            System.out.println("======================JSONFile to text======================");
            AbstractConverter JSONfileTotextConverter=
                    ConverterFactory.createConverter(Direction.JSON_TO_XML,Catalog.class);
            System.out.println(JSONfileTotextConverter.convert(new File(System.getProperty("user.dir")+"/src/by/it/patsko/jd02_10/taskC/Books.json")));

            System.out.println("======================JSONFile to XMLfile======================");
            AbstractConverter JSONfileToXMLfileConverter=
                    ConverterFactory.createConverter(Direction.JSON_TO_XML,Catalog.class);
            JSONfileToXMLfileConverter.convert(System.getProperty("user.dir")+"/src/by/it/patsko/jd02_10/taskC/Books.json");

        } catch (NoSuchMethodException | JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
