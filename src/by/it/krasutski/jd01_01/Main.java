package by.it.krasutski.jd01_01;

public class Main {
    public static void main(String[] args) {

        Hello h=new Hello();
        h.printSlogan();
        h.setSlogan("Привет Мир!");
        h.printSlogan();
        Args argObj=new Args(args);
        argObj.printArgs();
    }
}
