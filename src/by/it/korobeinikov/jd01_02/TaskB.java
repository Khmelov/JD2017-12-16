package by.it.korobeinikov.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args){
        int month;
        double a;
        double b;
        double c;
        step1();
        Scanner sc=new Scanner(System.in);
        month=sc.nextInt();
        step2(month);
        Scanner sc1=new Scanner(System.in);
        a=sc1.nextDouble();
        Scanner sc2=new Scanner(System.in);
        b=sc2.nextDouble();
        Scanner sc3=new Scanner(System.in);
        c=sc3.nextDouble();
        step3(a,b,c);
    }
    static void step1() {
        for (int i = 1; i < 26; i++) {
            if (i % 5 == 0) {
                System.out.println(i);}
                else {
                if (i > 9)
                System.out.print(i+ " ");
                else System.out.print(i+"  ");
            }
        }
    }
    static void step2(int month) {

        switch (month) {
            case 1 :{
                System.out.println("январь");
                break;
            }
            case 2 :{
                System.out.println("февраль");
                break;
            }
            case 3 :{
                System.out.println("март");
                break;
            }
            case 4 :{
                System.out.println("апрель");
                break;
            }
            case 5 :{
                System.out.println("май");
                break;
            }
            case 6 :{
                System.out.println("июнь");
                break;
            }
            case 7 :{
                System.out.println("июль");
                break;
            }
            case 8 :{
                System.out.println("август");
                break;
            }
            case 9 :{
                System.out.println("сентябрь");
                break;
            }
            case 10 :{
                System.out.println("октябрь");
                break;
            }
            case 11 :{
                System.out.println("ноябрь");
                break;
            }
            case 12 :{
                System.out.println("декабрь");
                break;
            }
            default: {
                System.out.println("нет такого месяца");
            }
        }
    }
    static void step3(double a,double b,double c) {
        double D;
        D=b*b-4*a*c;
        if (D<0) System.out.println("корней нет");
        else {
            double sD = Math.sqrt(D);
            double x1=((-b)+sD)/2*a;
            double x2=((-b)-sD)/2*a;
            if (x1==x2) System.out.println(x1);
            else System.out.println(x1+" "+x2);
        }
    }
}
