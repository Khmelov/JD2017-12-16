package by.it.patsko.jd01_02;

import java.util.Arrays;
import java.util.Scanner;



class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //TaskA
        int[] mas1 = new int[10];
        for (int i = 0; i < mas1.length; i++) {
            mas1[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(mas1));

        TaskA.step1(mas1);
        TaskA.step2(mas1);
        TaskA.step3(mas1);

        //TaskB
        TaskB.step1();
        TaskB.step2(sc.nextInt());
        TaskB.step3(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

        //TaskA
        int n=sc.nextInt();
        int[][] mas2 = TaskC.step1(n);
        TaskC.step2(mas2);
        TaskC.step3(mas2);
    }

}
