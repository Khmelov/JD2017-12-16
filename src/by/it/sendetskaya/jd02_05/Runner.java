package by.it.sendetskaya.jd02_05;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        boolean flag = true;
        DateFormat dateFormat;
        Date d =Calendar.getInstance().getTime();
        ResMan manager = ResMan.INSTANCE;


        String country ="";
        String language ="";
        Locale locale;


        System.out.println("Для переключения языка введите en-английский, " +
                "ru-русский, be-белорусский, end-выйти");

        while (flag) {
            Scanner sc = new Scanner(System.in);
            String strChoose = sc.nextLine();


            switch (strChoose) {
                case "en":
                    if (args.length==2) {
                        country = args[0];
                        language = args[1];
                    }
                    System.out.println("английский");
                    break;
                case "ru":
                    country = "RU";
                    language = "ru";
                    System.out.println("русский");
                    break;
                case "be":
                    country = "BY";
                    language = "be";
                    System.out.println("белорусский");
                    break;
                case "end":
                    flag = false;
                    break;
                default:
                    if (args.length==2) {
                        country = args[0];
                        language = args[1];
                    }
                    System.out.println("по умолчанию английский");
            }
            if (flag) {
                locale = new Locale(language, country);
                manager.setLocale(locale);

                dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
                System.out.println(manager.getString(Msg.Welcome));
                System.out.println(manager.getString(Msg.Question));
                System.out.println(manager.getString(Msg.Name));
                System.out.println(dateFormat.format(d));
                System.out.println("------------------------------------");

            }
        }
    }

}