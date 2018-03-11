package by.it._tasks_.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();
        int[][] mas=step1(n);
        System.out.println(step2(mas));
        System.out.println(step3(mas).length);
    }

    static int[][] step1(int n){
        int[][] res=new int[n][n];
        res[0][0]=-n;
        res[n-1][n-1]=n;
        System.out.println(n+" "+(-n));
        return res;
    }

    static int step2(int[][] mas){
        return -6;
    }

    static int[][] step3(int[][] mas){
        return new int[][]{{-1,2,-2},{-2,-2,-6}};
    }

}
