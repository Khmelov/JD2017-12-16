package by.it.sevashko.jd01_05;

public class Task4 {

    static double calculate(double n){
        double y;
        for (double a = 0; a < 2; a+=0.2) {
            y = 0;
            for (int x = 1; x < 7; x++) {
                y = y + Math.pow(7, a) - Math.cos(x);
            }
            System.out.println(y);
        }
        return n;
    }
}
