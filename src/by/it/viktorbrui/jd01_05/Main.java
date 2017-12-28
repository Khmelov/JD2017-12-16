package by.it.viktorbrui.jd01_05;

import by.it.viktorbrui.jd01_04.TaskA;

import static java.lang.Math.*;

public class Main {
    static void taskA1(){
        double a = 756.13;
        double x=0.3;
        double z=cos((pow(x*x+PI/6,5)));
        z = z-sqrt(x*pow(a,3));
        z=z-log(abs((a-1.12*x)/4));
        System.out.println("Result z="+z);
    }
    static void taskA2(){
        double a=1.12;
        double b=0.371;
       // double y=tan()
    }
    public static void main(String[] args) {
        taskA1();
        taskA2();
    }
}
