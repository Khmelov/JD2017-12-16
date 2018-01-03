package by.it.sevashko.jd01_05;

import static java.lang.Math.*;

public class Task2 {

    static double calculate(double a, double b){
        double y = tan(pow((a + b), 2)) - pow((a+1.5), (double) 1/3) + a*pow(b, 5) - b/log(a*a);
        return y;
    }
}
