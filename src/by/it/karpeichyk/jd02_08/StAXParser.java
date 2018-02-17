package by.it.karpeichyk.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by user on 13.02.2018.
 */
public class StAXParser {
    private static String tab="";
    public static void main(String[] args) {

        try {

            String filePath = "src/by/it/karpeichyk/jd02_07/Persons.xml";
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(new FileInputStream(filePath));
            String  el="";
            while (parser.hasNext()) {
                int event = parser.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT: {
                        System.out.print(tab + "[" + parser.getLocalName());
                        tab=tab+"\t";
                        int countAt=parser.getAttributeCount();
                        for (int i = 0; i <countAt ; i++) {
                            System.out.print(" " + parser.getAttributeLocalName(i) + "=");
                            System.out.print("\"" + parser.getAttributeValue(i) + "\"");
                        }
                        System.out.println("]");
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:{
                        el=el.concat(parser.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:{
                        if (!el.isEmpty())
                            System.out.println(tab+el);
                        tab=tab.substring(1);
                        el="";
                        System.out.println(tab+"[/"+parser.getLocalName()+ "]");
                        break;
                    }
                    case XMLStreamConstants.ATTRIBUTE:{
                        int countAt=parser.getAttributeCount();
                        for (int i = 0; i <countAt ; i++) {
                            System.out.print(" " + parser.getAttributeLocalName(i) + "=");
                            System.out.print("\"" + parser.getAttributeValue(i) + "\"");
                        }
                        System.out.println("]");
                        break;

                    }

                }
            }


        } catch (Exception e) {
            System.out.println("Error!!" + e.toString());
        }
    }}


