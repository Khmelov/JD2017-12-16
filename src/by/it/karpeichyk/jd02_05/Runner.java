package by.it.karpeichyk.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by user on 06.02.2018.
 */
public class Runner {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        //Scanner sc = new Scanner(System.in);
       // String strChoice = sc.nextLine();
        ResursProperity manager= ResursProperity.INSTANCE;
        if(args.length==2){

            Locale locale= new Locale(args[0],args[1]);
            manager.setLocale(locale);
        DateFormat df= DateFormat.getDateInstance(DateFormat.LONG, locale);
         String date=df.format(new Date());
        System.out.println(manager.get(Msg.Welcome));
        System.out.println(manager.get(Msg.Name));
        System.out.println(manager.get(Msg.Question));
        System.out.println(date);
    }}
}
