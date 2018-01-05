package by.it.pozdeev.jd01_05;


import by.it.pozdeev.jd01_03.InOut;
import by.it.pozdeev.jd01_03.Helper;

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
                    beta = sin(pow(x, 2));
                    break;
                case 2:
                    beta = cos(pow(x, 2));
                    break;
                case 3:
                    beta = 1 / tan(pow(x, 2));
                    break;
                case 0:
                    flag = true;
                    break;

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
        int n = toIntExact(round(Math.random() * 20 + 20));
        double delta = (9 - 5.33) / (n - 1);
        z = 0;
        x = 5.33;
        double[] mas = new double[n];
        for (int j = 0; j < n; j++) {
            mas[j] = pow(pow(x, 2) + 4.5, (double) 1 / 3);
            x = x + delta;
        }
        InOut.printArray(mas, "V", 5);
        i = 0;
        for (int j = 0; j < n; j++) {
            if (mas[j] > 3.5) i++;
        }
        System.out.println();
        double[] mas1 = new double[i];
        int k = 0;
        for (int j = 0; j < n; j++) {
            if (mas[j] > 3.5) {
                mas1[k] = mas[j];
                k++;
            }
            ;
        }
        InOut.printArray(mas1, "V1", 5);
        System.out.println();
        double sum = 1;
        for (int j = 0; j < i; j++) {
            sum = sum * mas1[j];
        }
        sum = pow(sum, (double) 1 / i);
        System.out.println(sum);
        System.out.println();
        int[] mas2 = new int[31];
        for (int j = 0; j < mas2.length; j++) {
            mas2[j] = toIntExact(round(Math.random() * 347 + 103));
        }
        k = 0;
        for (int j = 0; j < mas2.length; j++) {
            if (0.1 * mas2[j] > j) k++;

        }
        int[] mas3 = new int[k];
        k = 0;
        for (int j = 0; j < mas2.length; j++) {
            if (0.1 * mas2[j] > j) {
                mas3[k] = mas2[j];
                k++;
            }
        }
        char aa=0x2554,ab=0x2551;
        System.out.println(aa);
        for (int j = 0; j < mas2.length; j++) {
            System.out.print(ab);
            System.out.printf("%s[%-2d]=%-5d", "A", j + 1, mas2[j]);

            if ((j + 1) % 5 == 0 || j == mas2.length - 1) System.out.println();
        }
        k = 0;
        sort(mas3);
        do {
            for (int j = k; j < mas3.length; j = j + 5) {
                System.out.printf("%s[%-2d]=%-5d", "B", j+1, mas3[j]);
            }
            k++;
            System.out.println();
        }
        while (k<5);


    }
    public static void sort(int[] arr){
        boolean flag;
        int last = arr.length - 1;
        do {
            flag = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    int buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    flag = true;
                }
            }
            last--;
        }
        while (flag);
    }
}
