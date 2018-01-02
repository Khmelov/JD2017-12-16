package by.it.kozlov.jd01_05;

import static java.lang.Math.*;

public class Task3 {
    static void task3() {
        double f,x = 12.1;;
        for (double a = -5; a <= 12; a=a+3.75) {
            f = pow(E, a * x) - (3.45 * a);
            if (a<0) System.out.printf("При a = %.2f f = %.5f\n", a, f);
            else System.out.printf("При a = %.2f f = %.5e\n", a, f);
        }
    }
}
