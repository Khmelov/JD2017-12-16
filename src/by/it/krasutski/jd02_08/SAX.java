package by.it.krasutski.jd02_08;

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
    private StringBuilder content = new StringBuilder();
    private final static String filepath = "src/by/it/krasutski/jd02_07/Users+XSD.xml";

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser parser = saxParserFactory.newSAXParser();
            SAX sax = new SAX();
            parser.parse(new File(filepath), sax);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.print(tab + "<" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.printf(" %s='%s'", attributes.getLocalName(i), attributes.getValue(i));
        }
        System.out.println(">");
        tab = tab + "\t";

    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (!content.toString().isEmpty())
            System.out.println(tab + content);
        tab = tab.substring(1);
        content.setLength(0);
        System.out.println(tab + "</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String part = new String(ch, start, length);
        content.append(part.trim());
    }
}
