package by.it.fyodorov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число людей:");
        int x = sc.nextInt();
        String [] LastName = new String [x];

        for (int i = 0; i < LastName.length; i++) {
            LastName[i]=sc.next();
        }
        int[][] zp = new int[x][4];
        for (int i = 0; i < zp.length; i++) {
            System.out.println("Введите зарплату по кварталам для "+LastName[i]);
            for (int j = 0; j < zp[i].length; j++) {
                zp[i][j] = sc.nextInt();
            }
        }

        int sum_all = 0;
        System.out.println("Фамилия     Квартал1 Квартал2 Квартал3 Квартал4 Итого");

        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < zp.length; i++) {
            int sum = 0;
            System.out.printf("%10s: ",LastName[i]);
            for (int j = 0; j < zp[i].length; j++) {
                sum_all=sum_all+zp[i][j];
                sum=sum+zp[i][j];
                System.out.printf("%-9d",zp[i][j]);
            }
            System.out.printf("%-5d",sum);
            System.out.println();
        }
        System.out.println("-----------------------------------------------------");

        System.out.println("Итого       "+sum_all);

        System.out.printf("Средняя     %.4f",(double)sum_all/(x*4));
    }
}
