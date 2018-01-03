package by.it.Shalukhin.jd01_05.math;

import static java.lang.Math.*;

public class Task3 {
    public static void printTable(){
        for (double a = -5; a<=12; a=a+3.75){
            System.out.printf("a=%.2f\ty=%.4e\n",a,fun(a));
        }
    }
    static double fun (double a){
        double x = 12.1;
        double y = pow(E,a*x) - 3.45*a;
        return y;
    }
}
