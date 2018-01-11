package by.it.vshelukhin.jd01_05.math;

import static java.lang.Math.*;

public class Task1 {
    public static double optionA (double x){
        double a = 756.13;
        double z1 = cos(pow((x*x + PI/6),5));
        double z2 = pow(x*a*a*a,(double)1/2);
        double z3 = log(abs((a-1.12*x)/4));
        double z = z1 - z2 - z3;
        return z;
    }
    public static double optionB (double x){
        double a = 756.13;
        return cos(pow((x*x + PI/6),5)) - pow(x*a*a*a,(double)1/2) - log(abs((a-1.12*x)/4));
    }
}
