package by.it.vshelukhin.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main (String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите числа через пробел:");
        String st = sc.nextLine();
        double[] mas_d = InOut.getArray(st);
        InOut.printArray(mas_d);
        InOut.printArray(mas_d,"x",3);
        Helper.sort(mas_d);
        System.out.println(Arrays.toString(mas_d));

        double[][] a = {
                {-1, 1},
                {2, 0},
                {0, 3}
        };

        double[][] b = {
                {3, 1, 2},
                {0, -1, 4}
        };

        double[] c = {7, 4, 2};

        double[] n = Helper.mul(a, c);
        System.out.println(Arrays.toString(n)+"\n");

        double[][] m = Helper.mul(a, b);
        for (double[] doubles : m) {
            System.out.println(Arrays.toString(doubles));
        }
    }
}
