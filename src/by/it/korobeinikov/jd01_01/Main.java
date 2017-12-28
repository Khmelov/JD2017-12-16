package by.it.korobeinikov.jd01_01;

/**
 * Created by user on 16.12.2017.
 */
public class Main {
    public static void main(String[] args) {
        Hello h=new Hello();
        h.printSlogan();
        h.setSlogan("Привет мир!");
        h.printSlogan();
        Args a= new Args();
        a.printArguments(args);
    }
}
