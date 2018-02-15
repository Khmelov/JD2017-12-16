package by.it.kozlov.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSON {
    public static void main(String[] args) {
        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();

        Persons persons=new Persons();
        String json=gson.toJson(persons);
        System.out.println(json);
    }
}
