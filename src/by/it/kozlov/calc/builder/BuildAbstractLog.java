package by.it.kozlov.calc.builder;

import java.io.File;

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
}
