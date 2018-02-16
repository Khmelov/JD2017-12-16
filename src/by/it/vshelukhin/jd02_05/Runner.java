package by.it.vshelukhin.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
//        String language = "";
//        String country = "";
        Locale locale;

        ResoursManager resManager = ResoursManager.getResMan();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("en", "US"));
        //if (args.length == 2) resManager.setLocale(new Locale(args[0], args[1]));
        if (args.length == 2) {
            System.out.printf("Входные параметры: %s, %s\n", args[0], args[1]);
            String language = args[0];
            String country = args[1];
            locale = new Locale(language, country);
            resManager.setLocale(locale);
            df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        } else System.out.println("Входные параметры не установлены!");


        System.out.println(df.format(new Date()));
        System.out.printf("%s %s\n", resManager.getRes("str1"), resManager.getRes("str2"));

        //System.out.println(resManager.rb.getKeys());

        System.out.println("Выберете язык приветствия: \"ru\"-русский, \"be\"-беларуский, \"en\"-английский");
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("end")) {
            switch (line) {
                case "ru":
                    locale = new Locale("ru", "RU");
                    System.out.println("Для приветствия выбран русский язык!");
                    break;
                case "be":
                    locale = new Locale("be", "BY");
                    System.out.println("Для приветствия выбран белоруский язык!");
                    break;
                case "en":
                    locale = Locale.getDefault();
                    System.out.println("Для приветствия выбран английский язык!");
                    break;
                default:
                    locale = Locale.getDefault();
                    System.out.println("Такой язык не поддерживается. Приветствие будет выведено на английском языке.");
            }
            resManager.setLocale(locale);
            df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
            System.out.println(df.format(new Date()));
            System.out.printf("%s %s\n", resManager.getRes("str1"), resManager.getRes("str2"));
        }
    }
}
