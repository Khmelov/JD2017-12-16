package by.it.patsko.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StaxBooks {

    private static String tab = "";
    private static StringBuilder text = new StringBuilder();

    public static void main(String[] args) {
        try {
            String path = System.getProperty("user.dir") + "/src/by/it/patsko/jd02_08";
            String fileName = "Books.xml";
            FileInputStream input = new FileInputStream(new File(path, fileName));
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(input);

            while (reader.hasNext()) {
                switch (reader.next()) {
                    case XMLStreamReader.START_ELEMENT:
                        System.out.print(tab + "<" + reader.getLocalName());
                        for (int i = 0; i < reader.getAttributeCount(); i++) {
                            System.out.print(
                                    " " + reader.getAttributeLocalName(i) +
                                            "=" + reader.getAttributeValue(i));
                        }
                        System.out.println(">");
                        tab += '\t';
                        break;
                    case XMLStreamReader.CHARACTERS:
                        text.append(reader.getText().trim());
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        if (!text.toString().isEmpty()) System.out.println(tab + text);
                        text.setLength(0);
                        tab = tab.substring(1);
                        System.out.println(tab + "</" + reader.getLocalName() + ">");
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
