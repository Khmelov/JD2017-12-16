package by.it._tasks_.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        step1();
        int month=sc.nextInt();
        step2(month);
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        double c=sc.nextDouble();
        step3(a,b,c);
    }

    static void step1(){
        for (int i = 1; i < 26; i++){
            System.out.printf("%2d ",i);
            if (i%5==0)
                System.out.println();
        }
    }

    static void step2(int month){
        switch (month){
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

    static void step3(double a,double b,double c){
        double d=b*b-4*a*c;
        if (d>0) {
            double root1=(-b+Math.sqrt(d))/(2*a);
            double root2=(-b-Math.sqrt(d))/(2*a);
            System.out.print(root1+" "+root2);
        }
        else if (d==0) {
            double root=(-b)/(2*a);
            System.out.print(root);
        }
        else
            System.out.println("корней нет");
    }

}
