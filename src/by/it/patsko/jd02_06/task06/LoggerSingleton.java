package by.it.patsko.jd02_06.task06;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;

class LoggerSingleton {
    private static LoggerSingleton logger;
    private String path=System.getProperty("user.dir")+"/src/by/it/patsko/jd02_06/task06/";
    private String fileName="log.txt";
    private DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.FULL);
//    private BufferedWriter bw;        ??????

    private LoggerSingleton(){

    }
    public static LoggerSingleton getLogger(){
        if(logger==null) logger=new LoggerSingleton();
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

    public static void main(String[] args) {
        LoggerSingleton logger=LoggerSingleton.getLogger();
        try{
            for (int i = 10; i >=0 ; i--) {
                int num= 10/i;
                System.out.println(num);
                logger.logWrite(Double.valueOf(num).toString());
            }
        }catch (Exception e){
            logger.logWrite(e.getMessage());
        }
    }
}
