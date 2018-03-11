package by.it._tasks_.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    static void functionFour(double start, double finish, double step) {

        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y = y + Math.pow(7, a) - cos(x);
            }
            System.out.printf("При a=%4.2f Сумма y = %e\n", a, y);
        }
    }

    static void functionFive(double start, double finish, double step, double r) {

        for (double x = -6 + 0.5; x < 2; x += 0.5) {
            double b = 0;
            if ((-2 < x / 2) && (x / 2 <= -1))
                b = Math.sin(x * x);
            else if ((-2 < x / 2) && (x / 2 < 0.2))
                b = Math.cos(x * x);
            else if (x / 2 == 0.2)
                b = 1 / Math.tan(x * x);
            else {
                System.out.printf("При x/2=%4.2f вычисления не определены\n", x / 2);
                continue;
            }
            double a = Math.log10(Math.abs(b + 2.74));
            System.out.printf("При x/2=%4.2f a = %e\n", x / 2, a);


        }
    }

}
