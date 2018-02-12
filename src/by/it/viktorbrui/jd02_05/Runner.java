package by.it.viktorbrui.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan manager= ResMan.INSTANCE;
        if (args.length==2) {
            Locale locale=new Locale(args[0],args[1]);
            manager.setLocale(locale);
        }
        System.out.println(manager.get(Msg.Welcome));
        System.out.println(manager.get(Msg.Name));
        System.out.println(manager.get(Msg.Question));

    }
}
