package by.it.fyodorov.jd01_05.math;

import static java.lang.Math.*;

public class Task4 {
    public static void calculate (double x){
        for (double a = 0; a<=2; a=a+x){
            System.out.printf("a=%5.2f\ty=%10.5f\n",a,func(a));
        }
    }
    static double func (double a){
        double y = 0;
        for (int x = 1; x <= 6; x++) {
            y = y + pow(7, a) - cos(x);
        }
        return y;
    }
}
