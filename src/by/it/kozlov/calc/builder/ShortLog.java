package by.it.kozlov.calc.builder;

import by.it.kozlov.calc.CalcException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class ShortLog extends BuildAbstractLog {

    @Override
    public void buildHeader() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append("Краткий отчёт по калькулятору\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildTime() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append(dateFormat.format(new Date()) + "\n");
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
