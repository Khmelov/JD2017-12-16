package by.it.ikiselev.jd01_05;

import static java.lang.Math.*;

public class Main {
    static void taskA1(){
        double a=756.13;
        double x=0.3;
        double z=cos(pow(x*x+PI/6,5))-pow(x*pow(a,3),0.5)-log(abs(a-1.12*x)/4);
        System.out.println("Res ="+z);
    }





    public static void main(String[] args) {
        taskA1();
    }
}
