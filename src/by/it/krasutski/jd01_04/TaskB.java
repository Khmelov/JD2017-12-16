package by.it.krasutski.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] sName = new String[n];
        for (int i = 0; i < sName.length; i++) {
            sName[i] = sc.next();
        }
        int[][] summary = new int[n][4];
        for (int i = 0; i < summary.length; i++) {
            System.out.println("Введите зарплату для " + sName[i]);
            for (int j = 0; j < summary[0].length; j++) {
                summary[i][j] = sc.nextInt();
            }
        }
        printTable(sName, summary);
    }

    private static void printTable(String[] sName, int[][] summary) {
        int averageSum, totalSum = 0;
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n",
                "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < summary.length; i++) {
            averageSum = 0;
            System.out.printf("%10s", sName[i] + ": ");
            for (int j = 0; j < summary[0].length; j++) {
                averageSum += summary[i][j];
                System.out.printf("% -10d", summary[i][j]);
            }
            totalSum = totalSum + averageSum;
            System.out.printf("%-10d\n", averageSum);
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%-10s%-10d\n", "Итого", totalSum);
        System.out.printf("%-10s%-10f", "Средняя", (double) totalSum / (summary.length * summary[0].length));
    }
}
