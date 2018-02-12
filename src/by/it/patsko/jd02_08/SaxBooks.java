package by.it.patsko.jd02_08;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxBooks extends DefaultHandler {

    private String tab = "";
    private StringBuilder text=new StringBuilder();

    public static void main(String[] args) {
        try {
            String path = System.getProperty("user.dir") + "/src/by/it/patsko/jd02_08";
            String fileName = "Books.xml";

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

//            SaxBooks mySax = ;
            parser.parse(new File(path, fileName), new SaxBooks());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало парсинга");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Завершение парсинга");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + '<' + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(
                    " " + attributes.getLocalName(i) +
                    "=" + attributes.getValue(i));
        }
        System.out.println('>');
        tab+='\t';
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(!text.toString().isEmpty()) System.out.println(tab+text);
        text.setLength(0);
        tab=tab.substring(1);
        System.out.println(tab + "</" + qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(new String(ch, start, length).trim());
    }
}
