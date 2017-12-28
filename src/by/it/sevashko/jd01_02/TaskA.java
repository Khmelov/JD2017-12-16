package by.it.sevashko.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        int[] mas = {15, 51, 4, 34, 5, 46, 1, 15, 83, 1};
/*        Scanner sc = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < 10; i++) {
            mas[i] = sc.nextInt();
        }*/
        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[] mas){
        int min = mas[0];
        int max = mas [0];
        for (int element : mas) {
            if (element < min) min = element;
            if (element > max) max = element;
        }
        System.out. println(min + " " + max);
    }

    static void step2(int[] mas){
        int sum = 0;
        for(int i = 0; i < mas.length; i++){
            sum = sum + mas[i];
        }
        double average = sum/mas.length;
//        System.out.println(average);
        for (int i = 0; i < mas.length; i++){
            if(mas[i] < average) System.out.print(mas[i] + " ");
        }
    }
    static void step3(int[] mas){
        int min = mas[0];
        int minNum = 0;
        int minIndex = 0;
        System.out.println("");
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == min) minNum++;
            else if (mas[i] < min) {
                min = mas[i];
                minIndex = i;
                minNum = 1;
            }
        }
        if (minNum == 1) System.out.print(minIndex);
        else {
            for (int i = mas.length - 1; i >= 0; i--){
                if (mas[i] == min) System.out.print(i + " ");
            }
        }
//        System.out. println("\n" + min + " " + minNum);
    }
}
