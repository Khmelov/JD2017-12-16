package by.it.pozdeev.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = sc.next();
        }
        int[][] money = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + name[i]);
            for (int j = 0; j < 4; j++) {
                money[i][j] = sc.nextInt();
            }

        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s","Фамилия:","Квартал 1","Квартал 2","Квартал 3","Квартал 4","Итого:");
        System.out.println();
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < name.length; i++) {
            System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d",name[i],money[i][0],money[i][1],money[i][2],money[i][3],money[i][0]+money[i][1]+money[i][2]+money[i][3]);
            System.out.println();
        }
        System.out.println("------------------------------------------------------------");
        int sum=0;
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < 4; j++) {
                sum=sum+money[i][j];
            }
        }

        System.out.println("Итого:   "+sum);
        System.out.printf("%-9s,%9.4f","Средняя: "+(double)sum/4/n);

    }
}
