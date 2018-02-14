package by.it.vshelukhin.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class MyParserSAX extends DefaultHandler {

    static StringBuilder sb = new StringBuilder();

    static String tab = "";
    
    static String pass = "E:/Java/JD2017-12-16/src/by/it/vshelukhin/jd02_08/Students.xsd";

    public static void main(String[] args) {
        try {
            MyParserSAX mySAX = new MyParserSAX();
            File f = new File(pass);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(f, mySAX);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Парсер MySAX начал работу!");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Парсер MySAX закончил работу!");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.printf("%s{%s", tab, qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.printf(" %s='%s'",attributes.getLocalName(i),attributes.getValue(i));
        }
        System.out.printf("}\n");
        tab = tab+"\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tab = tab.substring(1);
        if (!sb.toString().isEmpty()) System.out.println(sb.toString());
        sb.setLength(0);
        System.out.println(tab+"{/"+qName+"}");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part = new String(ch, start, length);
        sb.append(part.trim());
        //sb.append(ch, start, length);
    }
}
