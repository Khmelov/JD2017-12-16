package by.it.kozlov.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StAX {
    static String tab = "";

    public static void main(String[] args) {
        String path = "src/by/it/kozlov/jd02_07/Persons XSD.xml";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(fileInputStream);

            String element = "";
            while (xmlStreamReader.hasNext()) {
                int type = xmlStreamReader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        System.out.println(tab + "[" + xmlStreamReader.getLocalName() + "]");
                        tab += "\t";
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        if (!element.isEmpty()) {
                            System.out.println(tab + element);
                        }
                        tab = tab.substring(1);
                        element = "";
                        System.out.println(tab + "[/" + xmlStreamReader.getLocalName() + "]");
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        element = element.concat(xmlStreamReader.getText().trim());
                        break;
                    }
                }

            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
