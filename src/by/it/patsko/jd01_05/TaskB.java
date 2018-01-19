package by.it.patsko.jd01_05;

import static java.lang.Math.*;

class TaskB {
    static void taskB1() {
        double y;
        for (double a = 0; a <= 2; a += 0.2) {
            y = 0;
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a)-cos(x);
            }
            System.out.printf("При a = %3.2f\ty = %e\n", a, y);
        }
    }

    static void taskB2() {
        double b = 0;
        for (double x = -5.5; x < 2; x += 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) b = sin(x * x);
            else if (x / 2 > -1 && x / 2 < 0.2) b = cos(x * x);
            else if (x / 2 == 0.2) b = 1 / tan(x * x);

            if (x / 2 <= -2 || x / 2 > 0.2) System.out.printf("При x/2 = %5.2f\tвычисления не определены\n", x / 2);
            else System.out.printf("При x/2 = %5.2f\ta = %e\n", x / 2, log10(abs(b + 2.74)));
        }
    }
}
