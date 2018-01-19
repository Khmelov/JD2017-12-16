package by.it.patsko.jd01_04;

import java.util.Scanner;

/**
 * Created by user on 23.12.2017.
 */
class TaskB {
    static void printTable(String[] fam, int[][] wage){
        int sum, totalSum=0;
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n",
                "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < wage.length; i++) {
            sum=0;
            System.out.printf("%-10s",fam[i]+" ");
            for (int j = 0; j < wage[i].length; j++) {
                sum+=wage[i][j];
                System.out.printf("%-10d",wage[i][j]);
            }
            totalSum+=sum;
            System.out.printf("%-10d\n", sum);
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10d\n","Итого",totalSum);
        System.out.printf("%-10s%-10f","Средняя",(double)totalSum/(wage.length*wage[0].length));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] fam=new String[n];
        for (int i = 0; i < fam.length; i++) {
            fam[i]=sc.next();
        }
        int[][] wage=new int[n][4];
        for (int i = 0; i < wage.length; i++) {
            System.out.println("Введите зарплату для "+fam[i]);
            for (int j = 0; j < wage[i].length; j++) {
                wage[i][j]=sc.nextInt();
            }
        }
        printTable(fam,wage);
    }
}
