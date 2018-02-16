package by.it.patsko.jd02_10.taskC;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.Objects;

class JsonToXmlConverter extends AbstractConverter {
    private JAXBContext context;
    private Marshaller marshaller;

    JsonToXmlConverter(Class PojoClass) throws JAXBException {
        super(PojoClass);
        context = JAXBContext.newInstance(PojoClass);
        marshaller = context.createMarshaller();
    }

    @Override
    String convert(File jsonFile) throws FileNotFoundException, JAXBException {
        if (Objects.requireNonNull(getFileExtension(jsonFile.getPath())).equals(".json")) {
            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            pojoObject = gson.fromJson(readFile(jsonFile), PojoClass);

            StringWriter sw = new StringWriter();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(pojoObject, sw);
            return sw.toString();
        } else throw new FileNotFoundException();
    }

    @Override
    void convert(String path) throws FileNotFoundException, JAXBException {
        File srcFile = new File(path);
        if (srcFile.exists()) {
            String fileContent = convert(srcFile);
            File resultFile = new File(
                    System.getProperty("user.dir") + "/src/by/it/patsko/jd02_10/taskC/Books2.xml");
            try (BufferedWriter bw =
                         new BufferedWriter(new FileWriter(resultFile))
            ) {
                bw.write(fileContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else throw new FileNotFoundException();
    }
}
