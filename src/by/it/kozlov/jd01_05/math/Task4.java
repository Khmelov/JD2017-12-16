package by.it.kozlov.jd01_05.math;

import static java.lang.Math.*;

public class Task4 {
    public static void calculate(double aDelta) {
        for (double a = 0; a <= 2; a = a + aDelta) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y = y + pow(7, a) - cos(x);
            }
            System.out.printf("При a=%f Сумма y = %f\n", a, y);
        }
    }
}
