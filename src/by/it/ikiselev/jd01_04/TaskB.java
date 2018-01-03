package by.it.ikiselev.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] lastName=new String[n];
        for (int i = 0; i < lastName.length; i++) {
            lastName[i]=sc.next();
        }
        int[][] pay=new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для "+lastName[i]);
            for (int j = 0; j < 4; j++) {
                pay[i][j]=sc.nextInt();
            }
        }
        String fam="Фамилия";
        String qurt1="Квартал1";
        String qurt2="Квартал2";
        String qurt3="Квартал3";
        String qurt4="Квартал4";
        String to="Итого";
        String averStr="Средняя";
        int total;
        int sum=0;
        float aver=0.f;
        System.out.printf("-----------------------------------------------------------");
        System.out.println();
        System.out.printf("%12.12s  %8.8s  %8.8s  %8.8s  %8.8s  %5.5s",fam,qurt1,qurt2,qurt3,qurt4,to);
        System.out.println();
        System.out.printf("-----------------------------------------------------------");
        System.out.println();
        for (int i = 0; i < n; i++) {
            int totalYear=0;
            System.out.printf("%12.12s  ",lastName[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d",pay[i][j]);
                totalYear=totalYear+pay[i][j];
                sum=sum+pay[i][j];
            }
            System.out.printf("%-5d",totalYear);
            System.out.println();
        }
        System.out.printf("%12.12s  %-7d",to,sum);
        System.out.println();
        aver=(float)sum/(4*n);
        System.out.printf("%12.12s  %-7.4f",averStr,aver);


    }

}
