package by.it.vshelukhin.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Locale;

public class ReportMakerFull extends ReportMaker {

    @Override
    void makeTitle() {
        report.setTitle("\nПолный отчёт");
    }

    @Override
    void formedReport() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("ru","RU"));
        StringBuilder sb = new StringBuilder();
        sb.append("Сессия началась: ");
        sb.append(StatisticInfo.startSession);
        sb.append("\n");
        for (StatisticInfo.CurrentEvent event : StatisticInfo.events) {
            sb.append(df.format(event.date));
            sb.append("\tвыражение: ");
            sb.append(event.expresson);
            sb.append("\tрезультат: ");
            sb.append(event.result);
            sb.append("\t");
            if (event.exception != null) sb.append(event.exception.getClass().getSimpleName());
            sb.append("\n");
        }
        sb.append("Сессия закончилась: ");
        sb.append(StatisticInfo.endSession);
        sb.append("\n");

        report.setReport(sb.toString());
        }

    @Override
    void printReportInFile() {
        File f = new File(getPass(),"ReportFull.txt");
        try (BufferedWriter br = new BufferedWriter(new FileWriter(f, true))){
            br.write(report.title);
            br.write("\n");
            br.write(report.report);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
