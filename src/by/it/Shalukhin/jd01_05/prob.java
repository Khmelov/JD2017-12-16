package by.it.Shalukhin.jd01_05;

import java.util.Arrays;

import static java.lang.Math.pow;
import static java.lang.Math.random;

public class prob {
    public static void main(String[] args) {
        int n = (int)(random()*21+20);
        System.out.println(n);
        double step = (9-5.33)/(n+1);
        System.out.println(step);
        double [] mas = new double[n];
        int i = 0;
        for (double x = 5.33+step; x < 9; x=x+step) {
            mas[i] = pow(x*x+4.5,(double)1/3);
            i++;
        }

        System.out.println(Arrays.toString(mas));
    }
}
