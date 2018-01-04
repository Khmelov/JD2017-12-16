package by.it.karpeichyk.jd01_05;
import static java.lang.Math.*;

/**
 * Created by user on 03.01.2018.
 */
public class Main {
    static void task1() {
        double a=756.13;
        double x=0.3;
        double z=cos((pow(x*x+PI/6,5)));
        z=z-sqrt((x*pow(a,3)));
        z=z-log(abs((a-1.12*x)/4));
        System.out.println("Результат вычислений: "+z);
    }

    public static void main(String[] args) {
        task1();
        task2();
         task3();

    }
    static void task2()
    {
        double a=1.21;
        double b=0.371;
        double y;
        y=tan(pow((a+b),2))-pow((a+1.5),1./3)+a*pow(b,5)-b/(log(pow(a,2)));
        System.out.println("Результат вычислений: "+y);
    }
    static void task3()
    {
        double x=12.1;
        double a;
        double f;
        for (a = -5; a <= 12; a+=3.75) {
            f=exp(a*x)-3.45*a;

            System.out.println("При а= "+a+" результат функции f= "+f);
        }

    }



}
