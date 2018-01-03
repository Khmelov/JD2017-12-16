package by.it.kozlov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] surName = new String[n];
        for (int i = 0; i < n; i++) {
            surName[i] = sc.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.printf("Введите зарплату для %s\n", surName[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = sc.nextInt();
            }
        }
        line();
        System.out.printf("Фамилия   ");
        for (int i = 0; i < n + 1; i++) {
            System.out.printf("Квартал%-4d", i + 1);
        }
        System.out.printf("Итого\n");
        line();
        double totalAll = 0;
        for (int i = 0; i < n; i++) {
            int total = 0;
            System.out.printf("%-8s: ", surName[i]);
            for (int j = 0; j < 4; j++) {
                total = total + salary[i][j];
                System.out.printf("%-11d", salary[i][j]);
            }
            totalAll=totalAll+total;
            System.out.printf("%-11d", total);
            System.out.println();
        }
        line();
        System.out.printf("Итого %7.0f\n",totalAll);
        System.out.printf("Средняя %9.4f\n", totalAll/(n*4));
        line();
    }

    static void line() {
        System.out.printf("-----------------------------------------------------------\n");
    }
}
