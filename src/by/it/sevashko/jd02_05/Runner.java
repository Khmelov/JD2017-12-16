package by.it.sevashko.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {

    private static ResMan manager = ResMan.INSTANCE;

    public static void main(String[] args) {
        if (args.length==2) {
            Locale locale=new Locale(args[0],args[1]);
            manager.setLocale(locale);
        }
        printMessages();
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("quit")){
            changeLocale(line.trim());
            printMessages();
        }
    }

    private static void changeLocale(String lang){
        Locale newLocale;
        switch (lang){
            case "be": {
                newLocale = new Locale("be","BY");
                break;
            }
            case "ru": {
                newLocale = new Locale("ru","RU");
                break;
            }
            case "en": {
                newLocale = Locale.ENGLISH;
                break;
            }
            default: newLocale = Locale.getDefault();
        }
        manager.setLocale(newLocale);
    }

    private static void printMessages(){
        System.out.println(manager.get(Msg.Hello));
        System.out.println(manager.get(Msg.Name));
        System.out.println(manager.get(Msg.Question));
        System.out.println(manager.getDate());
    }

}
