package by.it.patsko.jd01_01;

public class Main {
    public static void main(String[] args) {
        Hello h = new Hello();
        h.printSlogan();
        h.setSlogan("Привет мир!!!");
        h.printSlogan();
        Args a = new Args(args);
        a.printArgs();
    }
}