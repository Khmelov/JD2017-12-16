package by.it.pozdeev.jd01_05;

import by.it.pozdeev.jd01_03.InOut;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        double a = 756.13;
        double x = 0.3;
        double z = cos(pow(x * x + PI / 6, 5));
        z = z - sqrt(x * pow(a, 3));
        z = z - log(abs((a - 1.12 * x) / 4));
        System.out.println("Result z=" + z);
        a = 1.21;
        double b = 0.371;
        double y = tan(pow(a + b, 2)) - pow(a + 1.5, 0.333333333) + a * pow(b, 5) - b / (log(pow(a, 2)) / log(E));
        System.out.println("Result y=" + y);
        x = 12.1;
        double f = 0;
        for (a = -5; a < 12; a = a + 3.75) {
            f = pow(E, a * x) - 3.45 * a;
            System.out.printf("При a= %5.2f f=%6.4f", a, f);
            System.out.println();
        }
        System.out.println();
        y = 0;
        for (a = 0; a < 2; a = a + 0.2) {
            for (int i = 1; i < 7; i++) {
                y = y + pow(7, a) - cos(i);
            }
            System.out.printf("При a= %4.2f y=%6.4f", a, y);
            System.out.println();
            y = 0;
        }
        System.out.println();
        x = 0;
        int i = 0;
        double alfa = 0;
        double beta = 0;
        boolean flag = false;

        for (x = -6; x < 2; x = x + 0.5) {
            beta = 0;
            alfa = 0;
            flag = false;
            i = 0;
            if (x / 2 > -2 && x / 2 <= -1) i = 1;
            if (x / 2 > -1 && x / 2 < 0.2) i = 2;
            if (x / 2 == 0.2) i = 3;
            switch (i) {
                case 1:
                    beta = sin(pow(x, 2));break;
                case 2:
                    beta = cos(pow(x, 2));break;
                case 3:
                    beta = 1 / tan(pow(x, 2));break;
                case 0:
                    flag = true;break;

            }
            if (flag) {
                System.out.printf("При x/2=%3.2f вычисления не определены", x / 2);
                System.out.println();
            }

            if (!flag) {
                alfa = log10(beta + 2.74);
                System.out.printf("При x/2=%-4.2f a=%7.6f", x / 2, alfa);
                System.out.println();
            }
        }
        System.out.println();
        int n=toIntExact(round(Math.random()*20+20));
        double delta=(9-5.33)/(n-1);
        z=0;
        x=5.33;
        double[] mas=new double[n];
        for (int j = 0; j <n; j++) {

            mas[j]=pow(pow(x,2)+4.5,0.333333333);
            x=x+delta;
        }
        InOut.printArray(mas,"V",5);
        i=0;
        for (int j = 0; j <n ; j++) {
            if (mas[j]>3.5) i++;
        }
        System.out.println();
        double [] mas1=new double[i];
        int k=0;
        for (int j = 0; j <n; j++) {
            if (mas[j]>3.5){mas1[k]=mas[j];k++;};
        }
        InOut.printArray(mas1,"V1",5);
        double sum=1;
        for (int j = 0; j <i; j++) {
            sum=sum*mas1[j];
        }
        sum=pow(sum,1/i);
        System.out.println(sum);
        int [] mas2=new int[31];
        for (int j = 0; j <mas2.length ; j++) {
            mas2[j] = toIntExact(round(Math.random() * 347 + 103));
        }

    }
}
