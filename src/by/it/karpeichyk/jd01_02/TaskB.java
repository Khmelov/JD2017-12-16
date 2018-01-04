package by.it.karpeichyk.jd01_02;

import java.util.Scanner;

/**
 * Created by user on 20.12.2017.
 */
public class TaskB {
    public static void main(String[] args) {
        step1();

        Scanner sc1 = new Scanner(System.in);
        int month = sc1.nextInt();
        step2(month);

        double a, b, c;
        a = sc1.nextDouble();
        b = sc1.nextDouble();
        c = sc1.nextDouble();
        step3(a, b, c);

    }

    static void step1() {
        for (int i = 1; i < 26; i++) {
            if (i % 5 == 0) {
                System.out.printf("%2d ", i);
                System.out.println();
            } else {
                System.out.printf("%2d ", i);
            }

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
        }
    }

    static void step3(double a, double b, double c) {

        double d = (b * b) - 4 * a * c;
        if (d > 0) {
            d = Math.sqrt(d);
            double x1 = (-b + d) / (2 * a);
            double x2 = (-b - d) / (2 * a);
            System.out.println(x2);
            System.out.println(x1);
        } else if (d == 0) {
            double x = (-b) / (2 * a);
            System.out.println(x);
        } else {
            System.out.println("корней нет.");
        }


    }


}
