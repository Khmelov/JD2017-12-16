package by.it.krasutski.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        int[] mas=new int[10];
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < mas.length; i++) {
            mas[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(mas));
        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[] mas){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int element : mas) {
            if (element<min) min=element;
            if (element>max) max=element;
        }
        System.out.println(min + " " + max);
        System.out.println();


        }
    static void step2(int[] mas){
        double average = 0;
        for (int elem : mas) {
            average=average+elem;
        }
        average=average/mas.length;
        for (int elem : mas) {
            if (elem<average){
                System.out.print(elem+" ");
            }
        }
        System.out.println();
        System.out.println();


    }

    static void step3(int[] mas){
        int min=Integer.MAX_VALUE;
        for (int element : mas) {
            if (element<min) min=element;
        }
        for (int i = mas.length-1; i >= 0 ; i--) {
            if (mas[i]==min)
                System.out.print(i+" ");

        }
    }
}

