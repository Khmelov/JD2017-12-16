package by.it.sevashko.jd02_10.taskC;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.Objects;

class JsonToXmlConverter extends AbstractConverter {
    private Marshaller marshaller;

    JsonToXmlConverter(Class PojoClass) throws JAXBException {
        super(PojoClass);
        JAXBContext context = JAXBContext.newInstance(PojoClass);
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
        String[] sPath = path.split("[/\\\\]+");
        String name = "New" + sPath[sPath.length - 1].split("\\.")[0];
        File srcFile = new File(path);
        if (srcFile.exists()) {
            String fileContent = convert(srcFile);
            File resultFile = new File(
                    System.getProperty("user.dir") + "/src/by/it/sevashko/jd02_10/taskC/" + name + ".xml");
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
