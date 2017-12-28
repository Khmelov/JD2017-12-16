package by.it.krasutski.jd01_05;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        taskA1();
        taskA2();
        taskA3();
    }

    static void taskA1() {
        double a=756.13;
        double x=0.3;
        double z=cos((pow(x*x+PI/6,5)));
        z=z-sqrt(x*pow(a,3));
        z=z-log(abs((a-1.12*x)/4));
        System.out.println("Result z = "+z);
    }

    static void taskA2(){
        double a=1.21;
        double b=0.371;
        double y=tan((pow(a+b,2)));
        y=y-cbrt(a+1.5);
        y=y+a*pow(b,5);
        y=y-(b/log(abs(pow(a,2))));
        System.out.println("Result y = "+y);
    }

    static void taskA3(){
        double x=12.1;
        for (double i = -5; -5<=i&&i<=12; i=i+3.75) {
            double f=exp(i*x)-3.45*i;
            System.out.println("При a= "+i+" f="+f);
        }
    }
}
