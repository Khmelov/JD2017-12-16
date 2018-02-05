package by.it.patsko.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {
    static void printText(ResMan man){
        System.out.println(man.get(Message.Welcome));
        System.out.println(man.get(Message.Name));
        System.out.println(man.get(Message.Question));
        System.out.println(man.currentData());
        System.out.println();
    }
    static void chooseLocale(String command) {
        ResMan manager = ResMan.INSTANCE;
        Locale locale;
        switch (command) {
            case "ru":
                locale = new Locale("ru", "RU");
                manager.setLocale(locale);
                printText(manager);
                break;
            case "be":
                locale = new Locale("be", "BY");
                manager.setLocale(locale);
                printText(manager);
                break;
            case "en":
                manager.setLocale(Locale.getDefault());
                printText(manager);
                break;
            default:System.out.println("Unknown command");
        }
    }

    public static void main(String[] args) {
        /*ResMan manager = ResMan.INSTANCE;
        if(args.length==2){
            Locale locale=new Locale(args[0],args[1]);
            manager.setLocale(locale);
        }
        printText(manager);*/
        Scanner scanner=new Scanner(System.in);
        String line;

        while(!(line=scanner.nextLine()).equals("end"))
        chooseLocale(line);
    }
}
