package by.it.patsko.jd02_06.calc;

import java.text.DateFormat;
import java.util.Date;

public class ShortReport extends ReportBuilder{
    ShortReport(){
        super();
        dateFormat= DateFormat.getTimeInstance(DateFormat.SHORT);
    }
    @Override
    void writeHeader() {
        report.setHeader("Короткий отчет");
    }

    @Override
    void writeError(Exception error) {
        report.setErrors(dateFormat.format(new Date())+": "+
                error.getMessage());
    }
}
