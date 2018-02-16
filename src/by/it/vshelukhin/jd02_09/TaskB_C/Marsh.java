package by.it.vshelukhin.jd02_09.TaskB_C;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileOutputStream;
import java.io.FileReader;

public class Marsh {
    public static void main(String[] args) {
        String passOrigin = "E:\\Java\\JD2017-12-16\\src\\by\\it\\vshelukhin\\jd02_09\\TaskB_C\\Students+xsd.xml";
        String passRezult = "E:\\Java\\JD2017-12-16\\src\\by\\it\\vshelukhin\\jd02_09\\TaskB_C\\StudentsAuto.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(Students.class);
            Unmarshaller unMarsh = context.createUnmarshaller();
            FileReader reader = new FileReader(passOrigin);
            Students students = (Students) unMarsh.unmarshal(reader);
            System.out.println("Демаршализация завершена - исходный XML записан в виде экземпляра класса");

            Marshaller marsh = context.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marsh.marshal(students, new FileOutputStream(passRezult));
            System.out.println("Mаршализация завершена - на основе экземпляра класса сформирован XML");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
