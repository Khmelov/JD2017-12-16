package by.it.viktorbrui.jd01_01;

public class Main {
    public static void main(String[] args) {
        Hello h = new Hello();
        h.printSlogan();
        h.setSlogan("Привет мир!");
        h.printSlogan();
        Args a=new Args();
        a.printArguments(args);
    }
}
