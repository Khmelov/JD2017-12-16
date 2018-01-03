package by.it.viktorbrui.jd01_05;

import by.it.viktorbrui.jd01_04.TaskA;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        taskA1();
        taskA2();
        taskA3();
        taskA4();
        taskA5();
}
    static void taskA1(){
        double a = 756.13;
        double x=0.3;
        double z=cos((pow(x*x+PI/6,5)));
        z = z-sqrt(x*pow(a,3));
        z=z-log(abs((a-1.12*x)/4));
        System.out.println("Result z="+z);
    }
    static void taskA2(){
        double a=1.21;
        double b=0.371;
        double y;
        y=tan(pow((a+b),2))-pow((a+1.5),1./3)+a*pow(b,5)-b/(log(pow(a,2)));
        System.out.println("Результат вычислений: "+y);
    }
    static void taskA3() {
        double x = 12.1;
        double a;
        double f;
        for (a = -5; a <= 12; a += 3.75) {
            f = exp(a * x) - 3.45 * a;
            System.out.println("При а= " + a + " результат функции f= " + f);
        }

    }
    static void taskA4() {
        double y=0;
        int x;
        double a=0;
        while (a <=2){
            for (x = 1; x <=6; x++) {
                y+=pow(7.,a)*pow(7.,a)-cos(x);
            }
            System.out.printf("При а= %4.2f, ", a);
            System.out.println(" y= "+y);
            a+=0.2;
        }
    }
    static void taskA5(){
        double a,b,x;
        String s;
        for (x = -5.5; x < 2; x+=0.5) {
            if (x/2>-2&&x/2<=-1) {
                b = sin(pow(x, 2));
                a = log10(abs(b + 2.74));
                s=" a="+a;
            }
            else if (x/2>-1&&x/2<0.2) {
                b = cos(pow(x, 2));
                a=log10(abs(b+2.74));
                s=" a="+a;
            }
            else if (x/2==0.2) {
                b = 1.0 / tan(pow(x, 2));
                a = log10(abs(b + 2.74));
                s=" a="+a;
            }
            else
                s=" вычисления не определены";
            System.out.println("При x/2= " + x/2+s);
        }
        System.out.println();
    }
}
