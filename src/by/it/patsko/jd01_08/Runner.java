package by.it.patsko.jd01_08;
/*
Создать и реализовать интерфейсы в три (A) пять (В) или семь (С) методов. Необходимо использовать:
■	наследование (A)
■	статический полиморфизм, this (В)
■	динамический полиморфизм, this, super (С)
Каждый метод делает вывод в консоль с текстом сути метода.

interface Врач <-- abstract class Хирург <-- class Нейрохирург.
 */

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Patient[] p=new Patient[20];
        double[] tmpr=new double[p.length];
        int[] pUp=new int[p.length];
        int[] pDown=new int[p.length];
        int[] pls=new int[p.length];
        int[] pcnd=new int[p.length];
        ArrayList cnd=new ArrayList();
        for (int i = 0; i < p.length; i++) {
            p[i]=new Patient();

            tmpr[i]=p[i].temperature;
            pUp[i]=p[i].pressureUp;
            pDown[i]=p[i].pressureDown;
            pls[i]=p[i].pulse;
            pcnd[i]=p[i].patientCondition;
//            cnd.add(p[i].patientCondition);
        }
        show("temperature",tmpr);
        show("pressureUp",pUp);
        show("pressureDown",pDown);
        show("pulse",pls);
        show("patientCondition",pcnd);
        /*for (int i = -4; i <5 ; i++) {
            System.out.println(i+" "+cnd.contains(i));
        }*/


        /*String[] s=new String[20];
        for (int i = 0; i < s.length; i++) {
            s[i]=p.painAreas[(int)(Math.random()*p.painAreas.length)];
        }
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]+" ");
            if((i+1)%10==0)System.out.println();
        }*/

//        System.out.println(p);
    }
    static void show(String name, double[] arr){
        System.out.printf("%-20s",name);
        for (double number : arr) {
            System.out.printf("%-4.1f|",number);
        }
        System.out.println();
    }
    static void show(String name, int[] arr){
        System.out.printf("%-20s",name);
        for (int number : arr) {
            System.out.printf("%-4d|",number);
        }
        System.out.println();
    }
}
