package by.it.sendetskaya.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        String []mas=new String[n];
        Scanner sc1=new Scanner(System.in);
        for (int i = 0; i < mas.length; i++) {
            mas[i]=sc1.next();
        }
        //System.out.println(Arrays.toString(mas));

        int [][]mas1=new int[n][4];
        Scanner sc2=new Scanner(System.in);
        for (int i = 0; i < mas1.length; i++) {
            System.out.println("Введите зарплату для " + mas[i]);
            for (int j = 0; j < mas1[i].length; j++) {
                mas1[i][j] = sc2.nextInt();
            }
        }

        System.out.println("-------------------------------------------------------------");
        System.out.printf("%7s %9s %9s %9s %9s %9s","Фамилия", "Квартал1", "Квартал2", "Квартал3","Квартал4","Итого\n");
        System.out.println("-------------------------------------------------------------");

        int sum=0, sumGeneral=0;
        double avg=0;

        for (int i = 0; i < n; i++) {
            System.out.printf("%9s : ", mas[i]);
            for (int j = 0; j < 4; j++) {
                sum += mas1[i][j];
                System.out.printf("%-9d ", mas1[i][j]);

            }
            System.out.printf("%-9d ", sum);
            sumGeneral+=sum;
            sum=0;

            System.out.println();
        }
        avg=(double) sumGeneral/(n*4);
        System.out.println("-------------------------------------------------------------\n");
        System.out.printf("%-9s","Итого");
        System.out.printf("%-9d\n",sumGeneral);
        System.out.printf("%-9s %-6.4f","Средняя",avg);

    }
}
