package by.it.patsko.jd02_09;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
Создайте набор Java beans классов для маршализации-демаршализации виз XML с помощью JAXB.
Добавьте необходимые аннотации, конструкторы и методы toString.

 */
public class JAXBTransform {

    private final static String FileName=System.getProperty("user.dir")+"/src/by/it/patsko/jd02_09/Books.xml";
    private final static String FileName2=System.getProperty("user.dir")+"/src/by/it/patsko/jd02_09/Books2.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context=JAXBContext.newInstance(by.it.patsko.jd02_09.Catalog.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader reader=new FileReader(new File(FileName));
            by.it.patsko.jd02_09.Catalog catalog=(by.it.patsko.jd02_09.Catalog) unmarshaller.unmarshal(reader);
            System.out.println(catalog);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(catalog,new File(FileName2));

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }




}
