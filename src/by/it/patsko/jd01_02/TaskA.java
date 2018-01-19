package by.it.patsko.jd01_02;

import java.util.*;

class TaskA {
    public static void main(String[] args) {
//        int[] mas = {-1, 22, 33, 44, 567, 567, 44, 33, 22, -1, 4, 4};
        int[] mas = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < mas.length; i++) {
            mas[i] = sc.nextInt();
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
            if (min > element) min = element;
            if (max < element) max = element;
        }
        System.out.println(min + " " + max);
    }

    static void step2(int[] mas) {
        double avg = 0;
        for (int element : mas) {
            avg += element;
        }
        avg /= mas.length;
        for (int element : mas) {
            if (element < avg) System.out.print(element + " ");
        }
        System.out.println();
    }

    static void step3(int[] mas) {
        int min = Integer.MAX_VALUE;
        for (int element : mas) {
            if (min > element) min = element;
        }

        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min) System.out.print(i + " ");
        }
        System.out.println();
    }
}
