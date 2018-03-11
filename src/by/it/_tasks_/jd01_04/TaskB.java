package by.it._tasks_.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] fam=new String[n];
        for (int i = 0; i < n; i++) {
            fam[i]=sc.next();
        }

        int[][] pay=new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для "+fam[i]);
            for (int j = 0; j < 4; j++) {
                pay[i][j]=sc.nextInt();
            }
        }

        System.out.println("------------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("------------------------------------------------------");
        int sumAll=0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%7s: ",fam[i]);
            int sumOne=0;
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d",pay[i][j]);
                sumOne+=pay[i][j];
                sumAll+=pay[i][j];
            }
            System.out.printf("%-10d\n",sumOne);
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("Итого    %-10d\n",sumAll);
        System.out.printf("Средняя  %-10f\n",(double)sumAll/(n*4));
    }
}
