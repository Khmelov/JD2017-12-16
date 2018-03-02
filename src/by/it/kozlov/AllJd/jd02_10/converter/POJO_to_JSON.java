package by.it.kozlov.jd02_10.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class POJO_to_JSON<T> extends AbstractConverter<T> implements IConverter {
    @Override
    public <T1> void convert(T1 type) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir") + "/src/by/it/kozlov/jd02_10/converter/File.json")))) {
            String json = gson.toJson(type);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
