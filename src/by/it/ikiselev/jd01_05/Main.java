package by.it.ikiselev.jd01_05;

import static java.lang.Math.*;

public class Main {
    static void taskA1(){
        double a=756.13;
        double x=0.3;
        double z=cos(pow(x*x+PI/6,5))-pow(x*pow(a,3),0.5)-log(abs(a-1.12*x)/4);
        System.out.println("Res ="+z);
    }
    static void taskA2(){
        double a=1.21;
        double b=0.371;
        double y=tan(pow(a+b,2))-pow(a+1.5,1/3)+a*pow(b,5)-b/log(a*a);
        System.out.println("Res ="+y);
    }
    static void taskA3(){
        double x=12.1;
      //  double a=-5.0;
        for (double a = -5.0; a <=12 ; a=a+3.75) {
            double y=pow(E,a*x)-3.45*a;
            System.out.printf("При а=%f\ty=%f",a,y);
            System.out.println();

        }
    }
    public static void main(String[] args) {
        taskA1();
        taskA2();
        taskA3();
    }
}
