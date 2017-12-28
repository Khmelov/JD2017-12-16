package by.it.krasutski.jd01_02;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        step1();
        Scanner sc=new Scanner(System.in);
        int month=sc.nextInt();
        step2(month);
        double a=sc.nextInt();
        double b=sc.nextInt();
        double c=sc.nextInt();
        step3(a,b,c);
    }

    static void step1() {
        int[][] matrixA = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("% -3d",matrixA[i][j]);
            }
            System.out.println();
        }
     System.out.println();
    }

    static void step2(int month) {
        String monthString;
        switch (month){
            case 1: monthString = "январь";
                    break;
            case 2: monthString = "февраль";
                    break;
            case 3: monthString = "март";
                    break;
            case 4: monthString = "апрель";
                    break;
            case 5: monthString = "май";
                    break;
            case 6: monthString = "июнь";
                    break;
            case 7: monthString = "июль";
                    break;
            case 8: monthString = "август";
                    break;
            case 9: monthString = "сентябрь";
                    break;
            case 10: monthString = "октябрь";
                    break;
            case 11: monthString = "ноябрь";
                    break;
            case 12: monthString = "декабрь";
                    break;
            default: monthString = "нет такого месяца";
                    break;

        }
        System.out.print(monthString);
        System.out.println();
        System.out.println();
    }

    static void step3(double a, double b, double c){
        double D;
        D=b*b-4*a*c;
        if (D>0){
            double x1;
            double x2;
            x1=(-b - Math.sqrt(D))/(2*a);
            x2=(-b + Math.sqrt(D))/(2*a);
            System.out.println("Корни уравнения: x1 = " + x1 + " x2 = " + x2);
        }
        else if (D==0){
            double x;
            x=(-b - Math.sqrt(D))/(2*a);
            System.out.println("Корень уравнения: x = " + x);
        }
        else {
            System.out.println("корней нет");
        }
    }
}
