package by.it.patsko.jd02_06.calc;

import java.text.DateFormat;
import java.util.Date;

abstract class ReportBuilder {
    Report report;
    DateFormat dateFormat;

    Report getReport() {
        return report;
    }

    ReportBuilder() {
        report = new Report();
    }

    abstract void writeHeader();

    void writeStartSession() {
        report.setStartSession(dateFormat.format(new Date()));
    }

    void writeEndSession() {
        report.setEndSession(dateFormat.format(new Date()));
    }

     void writeOperation(String operation){
        report.setOperations(dateFormat.format(new Date())+": "+operation);
    }

    abstract void writeError(Exception error);

     public void printReport(){
        System.out.println(report);
     }
}
