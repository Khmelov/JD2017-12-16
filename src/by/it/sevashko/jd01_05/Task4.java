package by.it.sevashko.jd01_05;

public class Task4 {

    static void calculate(double x){
        double y;
        for (double a = 0; a < 2; a+=0.2) {
            y = 6 * Math.pow(7, a) - Math.cos(x);
            System.out.printf("При a=%.2f Сумма y = %e\n", a, y);
        }
    }
}
