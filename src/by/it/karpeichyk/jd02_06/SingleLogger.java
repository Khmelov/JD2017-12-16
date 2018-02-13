package by.it.karpeichyk.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.DateFormat;


import java.util.Date;




/**
 * Created by user on 06.02.2018.
 */
 class SingleLogger {
    private static SingleLogger instance;
    private  static final String PATH = System.getProperty("user.dir")+ "/src/by/it/karpeichyk/jd02_06/log.txt";
    private  SingleLogger(){}
   public static SingleLogger getInstance(){
            if (instance==null){
                instance=new SingleLogger();


        }
        return instance;
    }
    public  void log(String text){
        Date date = new Date();
        DateFormat dateformat =DateFormat.getDateTimeInstance();
        try(PrintWriter printWriter=
                   new PrintWriter(
                           new FileWriter(PATH,true)
                   )
        ) {
           printWriter.println(text);
           printWriter.println(dateformat.format(date));
       }catch (IOException e){
           e.printStackTrace();
       }
    }

}
