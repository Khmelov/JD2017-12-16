package by.it.karpeichyk.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {

        int mas []=new int[10] ;
        Scanner cs = new Scanner(System.in); // Объявляем Scanner
        for (int i = 0; i<10; i++) {
        mas[i]=cs.nextInt();}

           System.out.print (Arrays.toString(mas));
        System.out.println();
step1(mas);
    step2(mas);
    step3(mas);}


        static void step1(int [] mas){
        int m = mas [0];
        int n = mas[0];
            for (int i = 0; i <mas.length ; i++){
                if(m< mas[i]) {
                    m = mas[i];
                }
                if(n> mas[i]) {
                    n = mas[i];}
            }
            System.out.println(n +" "+m);
        }
static void step2(int [] mas){
    double sum=0;
    double sr =0;

    for (int i = 0; i < mas.length; i++) {
        sum+=mas[i];
        sr=sum/mas.length;}
    for (int j=0;j<mas.length;j++){
        if (mas[j]< sr){
            System.out.print(mas[j]+ " ");
        }}}

static  void  step3(int [] mas){
    System.out.println();
    int m=mas [0];
    for (int i = 0; i < mas.length; i++) {
        if (m>mas[i]) {
            m = mas[i];}}
    //System.out.println("min значение[" + n+"] =" + m);
    for (int i = mas.length-1; i>=0; i--) {
        if(m==mas[i]) System.out.printf(" %d",i);
}}
        }





