package by.it.akhmelev.jd02_06.classwork;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SingleLogger {

    private static SingleLogger instance;

    private static final String PATH = System.getProperty("user.dir") +
            "/src/by/it/akhmelev/jd02_06/classwork/log.txt";

    private SingleLogger() {

    }

    public static SingleLogger getInstance() {
        if (instance == null) {
            instance = new SingleLogger();
        }
        return instance;
    }

    public void log(String text) {
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new FileWriter(PATH, true)
                     )
        ) {
            printWriter.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
