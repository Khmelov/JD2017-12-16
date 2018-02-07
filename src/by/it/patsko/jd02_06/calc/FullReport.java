package by.it.patsko.jd02_06.calc;

import java.text.DateFormat;
import java.util.Date;

public class FullReport extends ReportBuilder {
    FullReport(){
        super();
        dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
    }

    @Override
    void writeHeader() {
        report.setHeader(" Полный отчет ");
    }

    @Override
    void writeError(Exception error) {
        StringBuilder result=new StringBuilder();
        result.append(dateFormat.format(new Date()));
        result.append(": ");
        result.append(error.getMessage()+"\n");

        StackTraceElement[] ste=error.getStackTrace();
        for (int i = 0; i < ste.length; i++) {
            result.append(ste[i]);
            result.append("\n");
        }
        report.setErrors(result.toString());
    }
}
