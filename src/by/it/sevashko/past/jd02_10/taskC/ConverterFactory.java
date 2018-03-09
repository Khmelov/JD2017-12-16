package by.it.sevashko.jd02_10.taskC;


import javax.xml.bind.JAXBException;

public class ConverterFactory {

    static AbstractConverter createConverter(Direction direction, Class pojoClass) throws NoSuchMethodException, JAXBException {
        if (direction.equals(Direction.JSON_TO_XML)) return new JsonToXmlConverter(pojoClass);
        else if (direction.equals(Direction.XML_TO_JSON)) return new XmlToJsonConverter(pojoClass);
        else throw new NoSuchMethodException();
    }
}
