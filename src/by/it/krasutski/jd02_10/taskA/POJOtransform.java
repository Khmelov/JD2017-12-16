package by.it.krasutski.jd02_10.taskA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class POJOtransform {

    private final static String PathJson = System.getProperty("user.dir") + "/src/by/it/krasutski/jd02_10/taskA/Dev.json";
    private final static String PathPOJO = System.getProperty("user.dir") + "/src/by/it/krasutski/jd02_10/taskA/Dev.txt";


    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String json = gson.toJson(new Dev());
        BufferedWriter bw = new BufferedWriter(new FileWriter(PathJson));
        bw.write(json);
        bw.close();
        System.out.println("Файл json создан.");
        Dev dev = gson.fromJson(json, Dev.class);
        BufferedWriter newBW = new BufferedWriter(new FileWriter(PathPOJO));
        newBW.write(dev.toString());
        newBW.close();
        System.out.println("Файл POJO создан.");
    }
}