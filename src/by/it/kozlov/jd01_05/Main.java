package by.it.kozlov.jd01_05;

import static java.lang.Math.*;

public class Main {

    public static void Main(String[] args) {
        taskA1();
        taskA2(1.21, 0.371);
        taskA3(12.1, 3.75);
    }

    static void taskA1() {
        double a = 756.13;
        double x = 0.3;
        double z = cos((pow(x * x + PI / 6, 5)));
        z = z - sqrt(x * pow(a, 3));
        z = z - log(abs((a - 1.12 * x) / 4));
        System.out.println("Result z = " + z);
    }

    static void taskA2(double a, double b) {
        double y;
        y = tan(pow((a + b), 2.0)) - pow((a + 1.5), (1.0 / 3.0)) + a * pow(b, 5.0) - b / log(a * a);
        System.out.println("Result y = " + y);
    }

    static void taskA3(double x, double a) {
        double f;
        for (double i = -5; i <= 12; i=i) {
            f = pow(E, a * i) - (3.45 * i);
            if (i<0) System.out.printf("При a = %.2f f = %.5f\n", i, f);
            else System.out.printf("При a = %.2f f = %.5e\n", i, f);
            i+=3.75;
        }
    }
}
