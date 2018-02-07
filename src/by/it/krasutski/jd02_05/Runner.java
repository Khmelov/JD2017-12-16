package by.it.krasutski.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        ResMan manager = ResMan.INSTANCE;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }
        printText(manager);
        Scanner scanner = new Scanner(System.in);
        String line;

        while (!(line = scanner.nextLine()).equals("end"))
            chooseLocale(line);
    }

    private static void chooseLocale(String command) {
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
            default:
                System.out.println("Incorrect input. Please try again.");
        }
    }

    private static void printText(ResMan manager) {
        System.out.println(manager.getLocale(Msg.Welcome));
        System.out.println(manager.getLocale(Msg.Name));
        System.out.println(manager.getLocale(Msg.Question));
        System.out.println(manager.currentData());
        System.out.println("_________________");
    }
}