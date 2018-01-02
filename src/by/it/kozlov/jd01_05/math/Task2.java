package by.it.kozlov.jd01_05.math;

import static java.lang.Math.*;

public class Task2 {
    public static double calculate(double a, double b) {
        double y;
        y = tan(pow((a + b), 2.0)) - pow((a + 1.5), (1.0 / 3.0)) + a * pow(b, 5.0) - b / log(a * a);
        return y;
    }
}
