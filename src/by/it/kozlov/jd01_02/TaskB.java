package by.it.kozlov.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner sc = new Scanner(System.in);
        step2(sc.nextInt());
        step3(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
    }

    static void step1() {
        int n = 5;
        int[][] mas = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                k++;
                mas[i][j] = k;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mas[i][j] < 10) System.out.print(" ");
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
                break;
        }

    }

    static void step3(double a, double b, double c) {
        double d;
        d = Math.pow(b, 2) - 4 * a * c;
        if (d < 0) System.out.println("корней нет");
        if (d == 0) {
            double x;
            x=(-b+Math.sqrt(d))/(2*a);
            System.out.println(x);
        };
        if (d > 0) {
            double x1,x2;
            x1=(-b+Math.sqrt(d))/(2*a);
            x2=(-b-Math.sqrt(d))/(2*a);
            System.out.println(x1+" "+x2);
        };
    }
}
