package by.it.vshelukhin.calc;

public class ReportDirector {
    private ReportMaker reportMaker;

    public void setReportMaker(ReportMaker reportMaker) {
        this.reportMaker = reportMaker;
    }
    public void makeReport(){
        reportMaker.createReport();
        reportMaker.makeTitle();
        reportMaker.formedReport();
        reportMaker.printReportInFile();
    }
}
