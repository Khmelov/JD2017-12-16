package by.it.kozlov.jd01_05.math;

import static java.lang.Math.*;

public class Task5 {
    public static void calculate() {
        double deltaX = 0.5;
        for (double x = -6 + deltaX; x < 2; x = x + deltaX) {
            if (x / 2 == 0.2) {
                double b = 1 / tan(pow(x, 2.0));
                System.out.printf("x=%f a=%e\n", x, log10(abs(b + 2.74)));
            } else if (x / 2 > -2 && x / 2 <= -1) {
                double b = sin(pow(x, 2.0));
                System.out.printf("x=%f a=%e\n", x, log10(abs(b + 2.74)));
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                double b = cos(pow(x, 2.0));
                System.out.printf("x=%f a=%e\n", x, log10(abs(b + 2.74)));
            }
        }
    }
}
