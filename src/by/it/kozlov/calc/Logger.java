package by.it.kozlov.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static volatile Logger logger;

    private Logger() {
    }

    public static Logger getLogger() {
        Logger localLogger = logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = logger;
                if (localLogger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
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
                Logger.class.getName()
                        .replace(Logger.class.getSimpleName(), "")
                        .replace(".", File.separator);
    }
}
