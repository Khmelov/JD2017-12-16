package by.it.sevashko.jd02_05;

import java.util.Locale;

public class TestLocale {

    public static void main(String[] args) {
        Locale loc = new Locale("be", "BY");
        System.out.println(loc.getDisplayCountry(Locale.ENGLISH));
    }
}
