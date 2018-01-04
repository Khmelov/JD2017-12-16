package by.it.karpeichyk.jd01_04;

import java.util.Scanner;

/**
 * Created by user on 29.12.2017.
 */
public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println("Количество работников :"+ s);
        String [] surname = new String[3];
        for (int i = 0; i<3; i++) {
            surname[i]=sc.next();}
       // System.out.println("Введите зарплату для "+ surname[1]);
        int N;
        int M =4;
       N=sc.nextInt();
       System.out.println(N);
        int [][]payment=new int[N][M];
        for (int i = 0; i < N; i++) {
            System.out.println("Введите зарплату для "+ surname[i]);
            for (int j = 0; j <M ; j++) {
                payment[i][j]=sc.nextInt();}}

            int sum0=payment[0][0]+payment[0][1]+payment[0][2];
        int sum1=payment[1][0]+payment[1][1]+payment[1][2];
        int sum2=payment[2][0]+payment[2][1]+payment[2][2];
        int Sum=sum0+sum1+sum2;
        double sumsr=Sum/12;

       // System.out.println(sum0);
      //for (int i = 0; i < N; i++) {
          //  for (int j = 0; j < M; j++) {
               // System.out.print(payment[i][j] + " ");
           // }
           // System.out.println();
   // }
        System.out.printf("%-20s%-10s%-10s%-10s%-10s%-10s%n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("------------------------------------------------------------------------------------");
System.out.printf("%-20s%-10d%-10d%-10d%-10d%-10d%n",surname[0],payment[0][0],payment[0][1],payment[0][2],payment[0][3],sum0);
        System.out.printf("%-20s%-10d%-10d%-10d%-10d%-10d%n",surname[1],payment[1][0],payment[1][1],payment[1][2],payment[1][3],sum1);
        System.out.printf("%-20s%-10d%-10d%-10d%-10d%-10d%n",surname[2],payment[2][0],payment[2][1],payment[2][2],payment[2][3],sum2);
        System.out.printf("%-20s%-10d%n","Итого",Sum);
        System.out.printf("%-20s%-10.4f%n","Средняя",sumsr);
}}
