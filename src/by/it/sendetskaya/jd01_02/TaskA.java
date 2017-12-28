package by.it.sendetskaya.jd01_02;


import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        //int[] mas = new int[]{22,-9,3, 2, 44, 21, 7, 0, 1, 10};
        int []mas=new int[12];
        Scanner sc3=new Scanner(System.in);
        for (int i = 0; i < mas.length; i++) {
            mas[i]=sc3.nextInt();
        }
        System.out.println(Arrays.toString(mas));


        TaskA.step1(mas);
        TaskA.step2(mas);
        TaskA.step3(mas);

    }

    static void step1(int[] mas) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int element : mas) {
            if (element < min)
                min = element;
            if (element > max)
                max = element;
        }
        //System.out.println("максимальный элемент = " + max);
        //System.out.println("минимальный элемент = " + min);

        System.out.print(min+" "+max);
        System.out.println();
    }

    static void step2(int[] mas) {
        //int mas1 []=new int[10];
        double avg = 0;
        for (int el : mas) {
            avg = avg + el;
        }
        avg = avg / mas.length;
        System.out.println("среднее: " + avg);
        System.out.print("элементы меньше среднего: ");
        //for (int i = 0; i < mas.length; i++) {
        //if(mas[i]<avg)
        //mas1[i]+=mas[i];

        for (int el : mas) {
            if (el < avg)
                System.out.print(el + " ");
        }
        System.out.println();
    }

    static void step3(int[] mas) {
        int min = Integer.MAX_VALUE;

        for (int element : mas) {
            if (element < min)
                min = element;
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}
