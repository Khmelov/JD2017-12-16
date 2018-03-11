package by.it._tasks_.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int[] m=new int[10];
        for (int i = 0; i < 10; i++) {
            m[i]=sc.nextInt();
        }
        step1(m);
        step2(m);
        step3(m);


        //простой пример, для расчета времени алгоритма

        int n=10;                           //1 шаг
        for (int i = 0; i < n; i++) {       //i=0 1 шаг, i<n - n раз, инкремент - n раз
            int counter=0;                  //n раз
            for (int j = i; j < n+i; j++) { //j=0 n раз, проверка n*n, инкремент n*n
                counter+=j;                  //инкремент счетчика n*n раз
            }
            System.out.println(counter);    //для простоты пусть это 1 оперция. n раз.
        }


        //итого операций будет 3*(n*n) + 5*n + 2




    }

    private static void step1(int[] mas){
        int[] m=Arrays.copyOf(mas,mas.length);
        Arrays.sort(m);
        System.out.println(m[0]+" "+m[m.length-1]);
    }

    static void step2(int[] mas){
        int[] m=Arrays.copyOf(mas,mas.length);
        double avg=0;
        for (int aM : m) avg += aM;
        avg=avg/m.length;
        for (int aM : m)
            if (aM<avg)
                System.out.println(aM+" ");

    }

    static void step3(int[] mas){
        int[] m=Arrays.copyOf(mas,mas.length);
        Arrays.sort(m);
        for (int i = mas.length-1; i >=0 ; i--)
            if (mas[i]==m[0])
                System.out.print(i+" ");
    }
}
