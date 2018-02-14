package by.it.vshelukhin.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;

import static javax.xml.stream.XMLStreamConstants.*;

public class MyParserStAX {

    static StringBuilder sb = new StringBuilder();

    static String tab = "";

    static String pass = "E:/Java/JD2017-12-16/src/by/it/vshelukhin/jd02_08/Students.xsd";

    public static void main(String[] args) {

        try {
            InputStream input = new FileInputStream(pass);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(input);
            while (parser.hasNext()){
                int type = parser.next();
                switch (type){
                    case START_ELEMENT:{
                        System.out.printf("%s{%s", tab, parser.getLocalName());
                        for (int i = 0; i < parser.getAttributeCount(); i++) {
                            System.out.printf(" %s='%s'",parser.getAttributeLocalName(i),parser.getAttributeValue(i));
                        }
                        System.out.printf("}\n");
                        tab = tab+"\t";
                        break;
                    }
                    case END_ELEMENT:{
                        tab = tab.substring(1);
                        if (!sb.toString().isEmpty()) System.out.println(sb.toString());
                        sb.setLength(0);
                        System.out.println(tab+"{/"+parser.getLocalName()+"}");
                        break;
                    }
                    case CHARACTERS:{
                        String text = parser.getText().trim();
                        sb.append(text);
                        break;
                    }
                    case START_DOCUMENT:{
                        System.out.println("Парсер MyStAX начал работу!");
                        break;
                    }
                    case END_DOCUMENT:{
                        System.out.println("Парсер MyStAX закочил работу!");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
