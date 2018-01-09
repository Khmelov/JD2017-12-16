package by.it.shalukhin.jd01_01;

public class Main {
    public static void main(String[] gg) {
        Hello h = new Hello();
        h.printSlogan();
        h.setSlogan("ПРЕВЕД");
        h.printSlogan();
        Args a = new Args();
        a.printArguments(gg);
    }
}
