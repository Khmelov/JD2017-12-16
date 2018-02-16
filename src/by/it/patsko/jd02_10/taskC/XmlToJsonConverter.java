package by.it.patsko.jd02_10.taskC;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Objects;


class XmlToJsonConverter extends AbstractConverter {
    JAXBContext context;
    Unmarshaller unmarshaller;

    XmlToJsonConverter(Class PojoClass) throws JAXBException {
        super(PojoClass);
        context = JAXBContext.newInstance(PojoClass);
        unmarshaller = context.createUnmarshaller();
    }

    @Override
    String convert(File xmlFile) throws FileNotFoundException, JAXBException {
        pojoObject = unmarshaller.unmarshal(xmlFile);
        if (Objects.requireNonNull(getFileExtension(xmlFile.getPath())).equals(".xml"))
            return gson.toJson(pojoObject);
        else throw new FileNotFoundException();
    }

    @Override
    void convert(String path) throws JAXBException, FileNotFoundException {
        File srcFile = new File(path);
        if (srcFile.exists()) {
            String fileContent = convert(srcFile);
            File resultFile = new File(
                    System.getProperty("user.dir") + "/src/by/it/patsko/jd02_10/taskC/Books.json");
            try (BufferedWriter bw =
                         new BufferedWriter(new FileWriter(resultFile))
            ) {
                bw.write(fileContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else throw new FileNotFoundException();
    }
}
