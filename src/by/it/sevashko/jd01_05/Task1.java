package by.it.sevashko.jd01_05;

import static java.lang.Math.*;

public class Task1 {

    static double optionA(double x){
        double a = 756.13;
        double p1 = cos(pow((x*x + PI/6), 5));
        double p2 = sqrt(x * pow(a, 3));
        double p3 = log(abs((a - 1.12 * x) / 4));
        double z = p1 - p2 - p3;
        return z;
    }

    static double optionB(double x){
        double a = 756.13;
        double z = cos(pow((x*x + PI/6), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        return z;
    }
}
