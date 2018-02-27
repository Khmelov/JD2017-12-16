package by.it.kozlov.calc.builder;

import by.it.kozlov.calc.CalcException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FullLog extends BuildAbstractLog {

    @Override
    public void buildHeader() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append("Полный отчёт по калькулятору\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildTime() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append(dateFormat.format(date) + " " + simpleDateFormat.format(date) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildData() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append(CalcException.stringQueue.poll() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
