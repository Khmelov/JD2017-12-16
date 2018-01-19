package by.it.patsko.jd01_05;

import static java.lang.Math.*;

class TaskA {
    static double taskA1() {
        double a = 756.13, x = 0.3;
        double z = cos(pow((x * x + PI / 6), 5));
        z -= sqrt(x * pow(a, 3));
        z -= log(abs((a - (1.12 * x)) / 4));
        return z;
    }

    static double taskA2() {
        double a = 1.21, b = 0.371;
        return tan(pow((a + b), 2)) - cbrt(a + 1.5) + a * pow(b, 5) - b / log(a * a);
    }

    static void taskA3() {
        double x = 12.1, f;
        for (double a = -5; a <= 12; a += 3.75) {
            f = pow(E, a * x) - 3.45 * a;
            System.out.printf("При a= %5.2f\tf=%g\n", a, f);
        }
    }
}
