package by.it.sevashko.jd02_10.taskA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSON_Murshaller {

    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        builder = builder.serializeNulls();
        builder = builder.setPrettyPrinting();
        Gson gson=builder.create();

        //маршализация
        User user = new User(1258, "VladSV", "qwerty",
                "Владислав", "Севашко", "vladossv@gmail.com", 1);
        String json = gson.toJson(user);
        System.out.println(json);

        //демаршализация
        User newUser = gson.fromJson(json, User.class);
        System.out.println(newUser);
    }
}
