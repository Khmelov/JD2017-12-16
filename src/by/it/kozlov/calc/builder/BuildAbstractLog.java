package by.it.kozlov.calc.builder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BuildAbstractLog {
    protected Log log;
    static File file = new File(getRoot(), "log.txt");

    public Log getLog() {
        return log;
    }

    public void createNewLog() {
        log = new Log();
    }

    public abstract void buildHeader();

    public abstract void buildTime();

    public abstract void buildData();

    private static String getRoot() {
        return System.getProperty("user.dir") +
                File.separator +
                "src" +
                File.separator +
                BuildAbstractLog.class.getName()
                        .replace(BuildAbstractLog.class.getSimpleName(), "")
                        .replace(".", File.separator);
    }


    static public void addMessage(String text) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append(dateFormat.format(date) + " " + simpleDateFormat.format(date) + " " + text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
