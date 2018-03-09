package by.it.sevashko.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int n = 2;

        String[] lastNames = new String[n];
        for (int i = 0; i < lastNames.length; i++) {
            lastNames[i] = sc.next();
        }
//        String[] lastNames = {"Ivanov", "Sidorov"};

        int[][] money = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.printf("Введите зарплату для %s\n", lastNames[i]);
            for (int j = 0; j < 4; j++) {
                money[i][j] = sc.nextInt();
            }
        }
//        int[][] money = {{11, 12, 13, 14}, {15, 16, 17, 18}};

        System.out.println("------------------------------------------------------");
        System.out.printf("%-8s %-9s %-9s %-9s %-9s %-9s\n","Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("------------------------------------------------------");
        int total = 0;
        for (int i = 0; i < lastNames.length; i++) {
            int sum = 0;
            System.out.printf("%7S:", lastNames[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%- 9d ", money[i][j]);
                sum = sum + money[i][j];
            }
            System.out.printf("%- 9d\n", sum);
            total = total + sum;
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%-8s %d\n", "Итого", total);
        double av1 = (double) total/4/n;
        System.out.printf("%-8s %.4f", "Средняя", av1);
    }


}
