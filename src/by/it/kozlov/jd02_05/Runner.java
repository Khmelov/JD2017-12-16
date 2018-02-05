package by.it.kozlov.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan man = ResMan.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Locale locale = new Locale(scanner.next());
            man.setLocale(locale);
            System.out.println(man.get(Msg.Welcome));
            System.out.println(man.get(Msg.Name));
            System.out.println(man.get(Msg.Question));
            System.out.println(man.getDate());
        }
    }
}
