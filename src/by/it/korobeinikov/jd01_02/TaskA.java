package by.it.korobeinikov.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 19.12.2017.
 */
public class TaskA {
    public static void main(String[] args) {
        int mas[] = new int[]{};
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
          mas[i]=sc.nextInt();
       }
        System.out.println(Arrays.toString(mas));
        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[] mas) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int element : mas) {
            if (element < min) min = element;
            if (element > max) max = element;
        }
        System.out.println(min + " " + max);
    }

    static void step2(int[] mas) {

        int sum = 0;
        double srznch = 0d;
        for (int i = 0; i < mas.length; i++) {
            sum = sum + mas[i];
        }
        srznch = (double)sum / mas.length;
        for (int i = 0; i < mas.length - 1; i++) {
            if (mas[i] < srznch) System.out.print(mas[i]+" ");
        }
        System.out.println();
    }


    static void step3(int[] mas) {
        int min = Integer.MAX_VALUE;
        for (int element : mas) {
            if (element < min) min = element;
        }
        for (int i = mas.length-1; i > -1; i--) {
            if (mas[i] == min) System.out.print(i+ " ");;
        }
        System.out.println();

    }
}

