package by.it.sendetskaya.jd02_06.calc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class Logger {

    private static Logger instance;

    private Logger() {

    }

    static Logger getInstance(){
        if(instance==null)
            instance=new Logger();

            return instance;
    }

    void logWrite(String message){
        String src=System.getProperty("user.dir")+"/src/";
        String fileLog=src+"by/it/sendetskaya/jd02_06/calc/log.txt";

        Date d=new Date();
        DateFormat df=DateFormat.getDateInstance(DateFormat.FULL);
        String line=df.format(d)+": "+message+"\n";
        try (BufferedWriter bw=new BufferedWriter(new FileWriter(fileLog, true))){
            bw.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
