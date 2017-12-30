package by.it.krasutski.jd01_05;

import java.util.Random;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        taskA1();
        taskA2();
        taskA3();
        taskB1();
        taskB2();
        taskC1();
    }

    static void taskA1() {
        double a=756.13;
        double x=0.3;
        double z=cos((pow(x*x+PI/6,5)));
        z=z-sqrt(x*pow(a,3));
        z=z-log(abs((a-1.12*x)/4));
        System.out.println("Result z = "+z);
        System.out.println();
    }

    static void taskA2(){
        double a=1.21;
        double b=0.371;
        double y=tan((pow(a+b,2)));
        y=y-cbrt(a+1.5);
        y=y+a*pow(b,5);
        y=y-(b/log(abs(pow(a,2))));
        System.out.println("Result y = "+y);
        System.out.println();
    }

    static void taskA3(){
        double x=12.1;
        for (double i = -5; -5<=i&&i<=12; i=i+3.75) {
            double f=exp(i*x)-3.45*i;
            System.out.println("При a= "+i+" f="+f);
        }
    }

    static void taskB1(){
        double y=0;
        for (double a = 0; 0<=a&&a<=2; a=a+0.2) {
            for (double x = 1; 1<=x&&x<=6 ; x++) {
                y+=pow(7,a)-cos(x);
            }
            System.out.println("При a= "+a+" y="+y);
        }
        System.out.println();
    }

    static void taskB2(){
        for (double x = -5.5; -6<x&&x<2; x=x+0.5) {
            double a;
            if (-2<(x/2)&&(x/2)<=-1) {
                a = log10((sin(pow(x,2))+2.74));
                System.out.println("При x/2="+x/2+" a=" + a);
            }
            else if (-1<(x/2)&&(x/2)<0.2) {
                a = log10(cos(pow(x, 2)) + 2.74);
                System.out.println("При x/2="+x/2+" a="+a);
            }
            else if ((x/2)==0.2) {
                a = log10(1/(tan(pow(x, 2))) + 2.74);
                System.out.println("При x/2="+x/2+" a="+a);
            }
            else
                System.out.println("При x/2="+x/2+" вычисления не определены");
        }
        System.out.println();
    }

    static void taskC1(){
        int v=5;
        Random random=new Random();
        int n=20+random.nextInt(41-20);
        double x= 3.75/(n+1);
        double[] arra=new double[n];
        for (int i = 0; i < arra.length; i++) {
            for (double j = 5.33+x; 5.33<j&&j<9; j=j+x) {
                double z=cbrt(j*j+4.5);
                arra[i++]=z;
                System.out.printf("A[% -3d] = "+"%2.4f"+" ",i-1,arra[i-1]);
                if ((0==(i)%v) || (arra.length-1==i-1)){
                    System.out.println();
                }
            }
        }
        System.out.println();
        double[] arrb=new double[arra.length];
        double key=3.5;
        int k=0;
        for (int i = 0; i < arra.length; i++) {
            if (arra[i]>key){
                arrb[k++]=arra[i];
                System.out.printf("B[% -3d] = "+"%2.4f"+" ",k-1,arrb[k-1]);
                if ((0==(k)%v) || (arrb.length-1==k)){
                    System.out.println();
                }
            }
        }
        System.out.println();
        System.out.println();
        double average=1;
        for (int j = 0; j < k; j++) {
            average=average*arrb[j];
        }
        average=pow(average,1./arrb.length);
        System.out.printf("Среднее геометрическое массива B = %2.4f",average);
    }

}
