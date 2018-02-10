package by.it.vshelukhin.calc;

import java.io.File;

public abstract class ReportMaker {

    Report report;

    void createReport(){
        report = new Report();
    }

    abstract void makeTitle();
    abstract void formedReport();
    abstract void printReportInFile();

    protected String getPass(){
        StringBuilder sbPath = new StringBuilder();
        sbPath.append(System.getProperty("user.dir"));
        sbPath.append(File.separator);
        sbPath.append("src");
        sbPath.append(File.separator);
        sbPath.append((new Report()).getClass().getName().replace((new Report()).getClass().getSimpleName(),"").replace(".",File.separator));
        return sbPath.toString();
    }
}
