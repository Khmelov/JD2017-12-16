package by.it.kozlov.jd02_06;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Instance {
    private static volatile Instance instance;

    private Instance() {
    }

    public static Instance getInstance() {
        Instance localInstance = instance;
        if (localInstance == null) {
            synchronized (Instance.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Instance();
                }
            }
        }
        return instance;
    }

    public void logger(String log) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        File file = new File(getRoot(), "log.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append(simpleDateFormat.format(new Date()) + " " + log + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getRoot() {
        return System.getProperty("user.dir") +
                File.separator +
                "src" +
                File.separator +
                Instance.class.getName()
                        .replace(Instance.class.getSimpleName(), "")
                        .replace(".", File.separator);
    }
}
