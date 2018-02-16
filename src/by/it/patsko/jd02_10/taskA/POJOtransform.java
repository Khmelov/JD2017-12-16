package by.it.patsko.jd02_10.taskA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class POJOtransform {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String json = gson.toJson(new Dev());
        System.out.println(json);
        System.out.println("===============");
        Dev dev = gson.fromJson(json, Dev.class);
        System.out.println(dev);
    }
}
