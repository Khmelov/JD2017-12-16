package by.it.ikiselev.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        int n;
        Scanner sc1 = new Scanner(System.in);
        n = sc1.nextInt();
        int[][] copy;
        copy=step1(n);
        step2(copy);
        step3(copy);
    }
    static int[][] step1 (int n){
        int[][] mas = new int[n][n];
        int[][] mas2 = new int[n][n];
        boolean tr3=false;
        do {
            boolean tr1=false;
            boolean tr2=false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int)(Math.random()*(2*n+1))-n;
                    System.out.print(mas[i][j] + " ");
                    if (mas[i][j]==n || mas[i][j]==-n){
                        if (mas[i][j]==n) {tr1=true;}
                        if (mas[i][j]==-n) {tr2=true;}
                    }
                }
                System.out.println();
            }
            tr3=tr1&tr2;
        } while(tr3==false);
        return mas;
    }
    static int step2 (int[][] mas ){
        int sum=0;
        int count=0;
        for (int i = 0; i < mas.length; i++) {
            count=0;
            int[] mem=new int[2];
            int dif=0;
            for (int j = 0; j < mas[0].length; j++) {
               if (mas[i][j]>0 && count<=2){
                    count=count+1;
                    if (count==1)
                    mem[0]= j;
                    else mem[1]=j;
                    if (count==2) break;
                }
            }
            dif=mem[1]-mem[0];
            if (count==2 && dif>1) {
                for (int j = mem[0] + 1; j < mem[1]; j++) {
                    sum = sum + mas[i][j];
                }
            }
        }
        System.out.println(sum);
        return sum;
    }
    static int[][] step3 (int[][] mas){
        int[] maxI=new int[mas.length];
        int[] maxJ=new int[mas.length];
        int countMaxI=0;
        int countMaxJ=0;
        for (int i = 0; i < mas.length; i++) {
            maxI[i] = Integer.MIN_VALUE;
            maxJ[i] = Integer.MIN_VALUE;
        }
        int max=mas[0][0];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                    if (mas[i][j] > max)
                        max = mas[i][j];
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] == max) {
                    maxI[i]=i;
                }
                if (mas[j][i] == max) {
                    maxJ[i]=i;
                }
            }
        }
        for (int i = 0; i < mas.length; i++) {
            if (maxI[i]>Integer.MIN_VALUE) countMaxI=countMaxI+1;
            if (maxJ[i]>Integer.MIN_VALUE) countMaxJ=countMaxJ+1;
        }
        int resultI=mas.length-countMaxI;
        int resultJ=mas.length-countMaxJ;
        int[][] masResult=new int[resultI][resultJ];
        int ci=-1;
        for (int i = 0; i <mas.length; i++) {
            if (i!=maxI[i]) {
                ci=ci+1;
                int cj=-1;
                for (int j = 0; j <mas.length; j++) {
                   if (j != maxJ[j]) {
                       cj=cj+1;
                       masResult[ci][cj]=mas[i][j];
                       System.out.print(masResult[ci][cj] + " ");
                   }
               }
                System.out.println();
            }
        }
     return masResult;
    }
}
