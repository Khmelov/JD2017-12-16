package by.it.kozlov.calc.builder;

public class Director {
    private BuildAbstractLog buildAbstractLog;

    public void setBuildAbstractLogBuilder(BuildAbstractLog lg) {
        buildAbstractLog = lg;
    }

    public Log getLog() {
        return buildAbstractLog.log;
    }

    public void constructLog() {
        buildAbstractLog.createNewLog();
        buildAbstractLog.buildHeader();
        buildAbstractLog.buildTime();
        buildAbstractLog.buildData();
    }
}
