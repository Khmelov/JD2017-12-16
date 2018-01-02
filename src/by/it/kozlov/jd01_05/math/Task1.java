package by.it.kozlov.jd01_05.math;

import static java.lang.Math.*;

public class Task1 {
    public static double optionA(double x) {
        double a = 756.13;
        double z = cos((pow(x * x + PI / 6, 5)));
        z = z - sqrt(x * pow(a, 3));
        z = z - log(abs((a - 1.12 * x) / 4));
        return z;
    }

    public static double optionB(double x) {
        double a = 756.13;
        double z = cos((pow(x * x + PI / 6, 5))) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        return z;
    }
}
