package by.it.kozlov.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAX extends DefaultHandler {
    private String tab = "";
    private final static String path = "src/by/it/kozlov/jd02_07/Persons XSD.xml";
    StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAX sax = new SAX();
            saxParser.parse(new File(path), sax);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Finish");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "[" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(attributes.getLocalName(i) + "=" + attributes.getValue(i));
        }
        System.out.println("]");
        tab += "\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!stringBuilder.toString().isEmpty()) {
            System.out.println(tab + stringBuilder);
        }
        tab = tab.substring(1);
        System.out.println(tab + "[/" + qName + "]");
        stringBuilder.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part = new String(ch, start, length);
        stringBuilder.append(part.trim());
    }
}
