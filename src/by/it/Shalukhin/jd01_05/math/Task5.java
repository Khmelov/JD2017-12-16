package by.it.Shalukhin.jd01_05.math;

import static java.lang.Math.*;

public class Task5 {
    public static void calculate(){
        double delta_x = 0.5;
        for (double x = -6+delta_x; x < 2; x=x+delta_x) {

            if (x/2 == 0.2) {
                double betta = 1/tan(x*x);
                System.out.printf("x=%5.2f\talpha=%10.5e\n",x,fun_alpha(betta));
            }
            else if (x/2 > -2 && x/2 <= -1) {
                double betta = sin(x*x);
                System.out.printf("x=%5.2f\talpha=%10.5e\n",x,fun_alpha(betta));
            }
            else if (x/2 > -1 && x/2 < 0.2) {
                double betta = cos(x*x);
                System.out.printf("x=%5.2f\talpha=%10.5e\n",x,fun_alpha(betta));
            }
            else System.out.printf("x=%5.2f\tвычисления не определены\n",x);
        }
    }

    static double fun_alpha (double bet){
        double alp = log10(abs(bet+2.74));
        return alp;
    }
}
