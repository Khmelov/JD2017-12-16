package by.it.sevashko.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StaxParser{

    private static String indent = "";
    private static StringBuilder text = new StringBuilder();

    public static void main(String[] args) {
        String xmlFile = String.format("%s%S", System.getProperty("user.dir"), "/src/by/it/sevashko/jd02_08/Users.xml");
        try {
            FileInputStream fileInputStream = new FileInputStream(xmlFile);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader xmlReader = factory.createXMLStreamReader(fileInputStream);
            while (xmlReader.hasNext()){
                int state = xmlReader.next();
                switch (state){
                    case XMLStreamConstants.START_ELEMENT:{
                        startElement(xmlReader);
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:{
                        text.append(xmlReader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:{
                        endElement(xmlReader);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void startElement(XMLStreamReader xmlReader){
        System.out.printf("%s[%s", indent, xmlReader.getLocalName());
        for (int i = 0; i < xmlReader.getAttributeCount(); i++){
            String name = xmlReader.getAttributeLocalName(i);
            String value = xmlReader.getAttributeValue(i);
            System.out.printf(" %s=%s", name, value);
        }
        System.out.println(']');
        indent = indent + '\t';
        text.delete(0, text.length());
    }

    private static void endElement(XMLStreamReader xmlReader){
        if (!text.toString().isEmpty()) {
            System.out.println(indent + text);
        }
        text.delete(0, text.length());
        indent = indent.substring(1);
        System.out.printf("%s[/%s]\n", indent, xmlReader.getLocalName());
    }
}
