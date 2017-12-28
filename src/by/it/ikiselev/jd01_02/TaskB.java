package by.it.ikiselev.jd01_02;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        int month;
        Scanner sc1 = new Scanner(System.in);
        month = sc1.nextInt();
        step2(month);
        double[] mas = new double[3];
        for (int i = 0; i < 3; i++) {
            mas[i] = sc1.nextDouble();
        }
        step3(mas[0],mas[1],mas[2]);
    }
    static void step1() {
        int[][] matrix;
        matrix = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = (i * 5) + (j + 1);
                if (matrix[i][j] < 10)
                    System.out.print(" " + matrix[i][j] + " ");
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void step2(int month1) {
        if (month1<1 || month1>12) System.out.println("нет такого месяца");
        switch (month1) {
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
        }
    }
    static void step3(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        if (d < 0) System.out.println("корней нет");
        else if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(x1+" "+x2);
        } else {
            double x1 = -b/(2*a);
            System.out.println(x1);
        }
    }
}