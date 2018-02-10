package by.it.krasutski.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class StAX {

    private final static String filepath = "src/by/it/krasutski/jd02_07/Users+XSD.xml";

    public static void main(String[] args) {
        StringBuilder tab = new StringBuilder();
        StringBuilder content = new StringBuilder();
        String name;
        try (FileInputStream fileReader = new FileInputStream(filepath)) {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
            //start
            while (reader.hasNext()) {
                int operation = reader.next();
                switch (operation) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        System.out.print(tab + "<" + name);
                        int attrCount = reader.getAttributeCount();
                        for (int i = 0; i < attrCount; i++) {
                            System.out.printf(" %s='%s'", reader.getAttributeLocalName(i), reader.getAttributeValue(i));
                        }
                        System.out.println(">");
                        tab.append("\t");
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (!content.toString().isEmpty())
                            System.out.println(tab.toString() + content);
                        tab = new StringBuilder(tab.substring(1));
                        content.setLength(0);
                        System.out.println(tab + "</" + reader.getLocalName() + ">");
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        content.append(reader.getText().trim());
                        break;
                }
            }
            //end
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
