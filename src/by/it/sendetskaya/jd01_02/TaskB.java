package by.it.sendetskaya.jd01_02;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        TaskB.step1();

        System.out.println("Введите число от 1 до 12 для вывода соответствующего месяца: ");
        Scanner sc=new Scanner (System.in);
        int month=sc.nextInt();
        TaskB.step2(month);

        System.out.println("Введите числа для решения квадратного уравнения через Enter (первое не может=0!): ");
        Scanner sc1=new Scanner (System.in);
        double a=sc1.nextInt();
        double b=sc1.nextInt();
        double c=sc1.nextInt();
        TaskB.step3(a,b,c);

    }

    //вывести матрицу нхн в формате 2 символов и пробела
    static void step1()
    {
        System.out.println("Матрица NxN: ");
        int n=1;
        int mas[][]=new int[5][5];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j]=n;

                System.out.printf("%3d",mas[i][j]);
            n++;
            }
            System.out.println();
        }
    }

    //ввести с консоли число от 1 до 12 с ним вызвать метод step2,вывести название месяца с больш буквы
    static void step2(int month)
    {
        switch (month) {
            case 1: {
                System.out.println("январь");
                break;
            }
            case 2: {
                System.out.println("февраль");
                break;
            }
            case 3: {
                System.out.println("март");
                break;
            }
            case 4: {
                System.out.println("апрель");
                break;
            }
            case 5: {
                System.out.println("май");
                break;
            }
            case 6: {
                System.out.println("июнь");
                break;
            }
            case 7: {
                System.out.println("июль");
                break;
            }
            case 8: {
                System.out.println("август");
                break;
            }
            case 9: {
                System.out.println("сентябрь");
                break;
            }
            case 10: {
                System.out.println("октябрь");
                break;
            }
            case 11: {
                System.out.println("ноябрь");
                break;
            }
            case 12: {
                System.out.println("декабрь");
                break;
            }
            default:
            {
                System.out.println("нет такого месяца");
            }

        }
    }

    //рассчитать и вывести корни квадратного уровнения введ с консоли
    static void step3(double a,double b, double c)
    {
        double x1, x2, d;
        if (a!=0)
        {
            d=Math.pow(b,2)-4*a*c;
            if (d>0)
            {
                System.out.println("Уравнение имеет два корня");
                x1=(-b+Math.sqrt(d))/(2*a);
                x2=(-b-Math.sqrt(d))/(2*a);
                System.out.println("x1="+x1+" x2="+x2);
            }
            else if (d==0)
            {
                System.out.println("Уравнение имеет один корень");
                x1=(-b+Math.sqrt(d))/(2*a);
                System.out.println("x1="+x1);
            }
            else
            {
                System.out.println("корней нет");
            }
        }
        else
            System.out.println("Первое число не может быть 0!!!");

    }

}
