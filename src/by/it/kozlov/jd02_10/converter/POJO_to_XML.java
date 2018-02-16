package by.it.kozlov.jd02_10.converter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class POJO_to_XML<T> extends AbstractConverter<T> implements IConverter {
    @Override
    public <T1> void convert(T1 type) {
        try {
            JAXBContext context = JAXBContext.newInstance(type.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(type, new File(System.getProperty("user.dir") + "/src/by/it/kozlov/jd02_10/converter/File.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
