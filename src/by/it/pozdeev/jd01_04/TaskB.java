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


    }
}
