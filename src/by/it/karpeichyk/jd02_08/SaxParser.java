package by.it.karpeichyk.jd02_08;



import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by user on 10.02.2018.
 */
public class SaxParser extends DefaultHandler{
    private String tab="";
    private  StringBuilder text= new StringBuilder();
    private final static String filePath= "src/by/it/karpeichyk/jd02_07/Persons.xml";

    public static void main(String[] args) {
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser= factory.newSAXParser();
           SaxParser s =new SaxParser();
            parser.parse(new File(filePath),s);
        }catch (ParserConfigurationException|SAXException|IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public void startDocument() throws SAXException {
        System.out.println("start Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        System.out.print(tab + "[" + qName);
        for (int i = 0; i <attributes.getLength() ; i++) {
            System.out.printf("%s='%s'",attributes.getLocalName(i),attributes.getValue(i));
        }
        System.out.println("]");
        tab=tab + "\t";
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end Document");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(!text.toString().isEmpty())
            System.out.println(tab+ text);
        tab= tab.substring(1);
       text.setLength(0);
        System.out.println(tab + "[/" + qName+ "]");
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part =new String(ch,start,length);
        text.append(part.trim());
    }
}

