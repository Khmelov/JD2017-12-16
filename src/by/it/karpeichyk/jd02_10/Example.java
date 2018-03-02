package by.it.karpeichyk.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by user on 28.02.2018.
 */
public class Example {
    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        builder = builder.serializeNulls();
        builder = builder.setPrettyPrinting();
        Gson gson = builder.create();
        String [] skills = {"java", "gson", "json"};
        POJOforExample pojOforExample = new POJOforExample("Ivanov",skills);

        String json = gson.toJson(pojOforExample);
        System.out.println(json);
        System.out.println("========================");

        POJOforExample pojOforExample11 = gson.fromJson(json, POJOforExample.class);
        System.out.println("\n\npojOforExample=" + pojOforExample11.toString());
    }
}
