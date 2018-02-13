package by.it.patsko.jd02_09;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
/*
Выполните по аналогии с Заданием 12 из рабочей тетради –преобразование XML в HTML файл с таблицей,
в которой каждая отдельная строка это одна из повторяющихся сущностей XML.
(используйте свой XML-файл без схемы и DTD из предыдущих заданий).
 */
public class XMLtoHTMLtransform {
    private static final String Path="file:///"+System.getProperty("user.dir")+"/src/by/it/patsko/jd02_09/";//????????
    private static final String XMLfileName="Books.xml";
    private static final String XSLfileName="Books.xsl";
    private static final String HTMLfileName="Books.html";

    public static void main(String[] args) {
        try {
            TransformerFactory factory=TransformerFactory.newInstance();
//            System.out.println(Path+XSLfileName);
            Transformer transformer = factory.newTransformer(new StreamSource(Path+XSLfileName));
            transformer.transform(new StreamSource(Path+XMLfileName),new StreamResult(Path+HTMLfileName));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

}
