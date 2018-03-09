package by.it.sevashko.jd01_05;
import static java.lang.Math.*;
public class Task3 {

    static void printTable(){
        double f;
        double x = 12.1;
        for (double a = -5; a <= 12 ; a+=3.75) {
            f = pow(E, a*x) - 3.45*a;
            System.out.printf("При a=%6.2f f=%.6g\n", a, f);
        }
    }
}
