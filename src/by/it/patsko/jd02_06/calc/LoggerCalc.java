package by.it.patsko.jd02_06.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

class LoggerCalc {
    private static LoggerCalc logger;
    private String path=System.getProperty("user.dir")+"/src/by/it/patsko/jd02_06/calc/";
    private String fileName="logCalc.txt";
    private DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
//    private BufferedWriter bw;        ??????

    private LoggerCalc(){

    }
    public static LoggerCalc getLogger(){
        if(logger==null) logger=new LoggerCalc();
        return logger;
    }

     void logWrite(String text){
         try (BufferedWriter bw = new BufferedWriter(
                      new FileWriter(
                              new File(path,fileName),true))
         ) {
                bw.write(dateFormat.format(new Date())+": "+text+"\n");
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}
