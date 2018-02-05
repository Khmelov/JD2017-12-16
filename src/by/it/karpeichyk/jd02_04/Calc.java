package by.it.karpeichyk.jd02_04;

/**
 * Created by user on 05.02.2018.
 */
public class Calc {
    static int add (int a,int b){ return a + b;}
    static int sub (int a,int b){ return a - b;}
    static int mul (int a,int b){ return a * b;}
    static int div (int a,int b){ return a / b;}
    static int ost (int a,int b){ return a % b;}

    public static void main(String[] args) {
        System.out.println("1+2=" + add(1,2));
    }
}
