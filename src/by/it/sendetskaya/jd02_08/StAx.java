package by.it.sendetskaya.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class StAx {

    private static String tab="";
    private static StringBuilder text = new StringBuilder();
    private final static String filePath = "src/by/it/sendetskaya/jd02_07/Shop+XSD.xml";

    public static void main(String[] args) {

        try (FileInputStream inputStream=new FileInputStream(filePath)) {
            XMLInputFactory factory=XMLInputFactory.newInstance();
            XMLStreamReader reader=factory.createXMLStreamReader(inputStream);

            while (reader.hasNext()){
                int type=reader.next();

                switch (type){
                    case XMLStreamConstants.START_ELEMENT:
                    {
                        System.out.print(tab + "<" + reader.getLocalName());

                        for (int i = 0; i < reader.getAttributeCount(); i++) {
                            System.out.printf(" %s='%s'", reader.getAttributeLocalName(i), reader.getAttributeValue(i));
                            System.out.print(" ");
                        }
                        System.out.println(">");
                        tab = tab + "\t";
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:
                    {
                        String part = new String(reader.getText());
                        text.append(part.trim());
                        break;
                    }

                    case XMLStreamConstants.END_ELEMENT:
                    {
                        if(!text.toString().isEmpty())
                            System.out.println(tab+text);
                        tab=tab.substring(1);
                        text.setLength(0);
                        System.out.println(tab+"</"+reader.getLocalName()+">");
                        break;
                    }
                }
            }
        }  catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }


    }
}
