package by.it.korobeinikov.jd01_05;
import static java.lang.Math.*;

public class Main {
    static void taskA1() {
        double a=756.13;
        double x=0.3;
        double z=cos(pow((x*x+PI/6),5))-sqrt(x*pow(a,3))-log10(abs((a-1.21*x)/4));
        System.out.println(z);
    }
    public static void main(String[] args) {
        taskA1();
    }
}
