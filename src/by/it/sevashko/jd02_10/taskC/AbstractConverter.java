package by.it.sevashko.jd02_10.taskC;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBException;
import java.io.*;

abstract class AbstractConverter<T> {
    final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    Class PojoClass;
    T pojoObject;

    static String getFileExtension(String path) {
        int index = path.indexOf('.');
        return index == -1 ? null : path.substring(index);
    }
    AbstractConverter(Class PojoClass) {
        this.PojoClass = PojoClass;
    }

    abstract String convert(File file) throws FileNotFoundException, JAXBException;

    abstract void convert(String path) throws JAXBException, FileNotFoundException;

    String readFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
