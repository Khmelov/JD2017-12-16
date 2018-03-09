package by.it.sevashko.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser extends DefaultHandler {

    private String indent = "";
    private StringBuilder text = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.printf("%s[%s", indent, qName);
        for (int i = 0; i < attributes.getLength(); i++){
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            System.out.printf(" %s=%s", name, value);
        }
        System.out.println(']');
        indent = indent + '\t';
        text.delete(0, text.length());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!text.toString().isEmpty()) {
            System.out.println(indent + text);
        }
        text.delete(0, text.length());
        indent = indent.substring(1);
        System.out.printf("%s[/%s]\n", indent, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(new String(ch, start, length).trim());
    }

    public static void main(String[] args) {
        String xmlFile = String.format("%s%S", System.getProperty("user.dir"), "/src/by/it/sevashko/jd02_08/Users.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(xmlFile, new SaxParser());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
