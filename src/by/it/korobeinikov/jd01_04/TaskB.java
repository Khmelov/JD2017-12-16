package by.it.korobeinikov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args){
        int PeopleCount = 0;
        Scanner sp=new Scanner(System.in);
        PeopleCount=sp.nextInt();
        String[] SurName=new String[PeopleCount];
        Scanner ss=new Scanner(System.in);
        for (int i = 0; i < PeopleCount; i++) {
            SurName[i]=ss.next();
        }
        double[][]Quatrum = new double[PeopleCount-1][4];
        double Itogo=0;
        for (int i = 0; i < PeopleCount; i++) {
            System.out.println("Введите зарплату для "+SurName[i]);
            for (int j = 0; j < 4; j++) {
                Scanner sc=new Scanner(System.in);
                Quatrum[i][j]=sc.nextDouble();
            }
            double SrZn = Quatrum[i][0]+Quatrum[i][1]+Quatrum[i][2]+Quatrum[i][3];
            Quatrum[i][4]=SrZn;
            Itogo= Itogo + SrZn;
        }
        double SrZar = Itogo/(4*PeopleCount);

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-13s%-10s%-10s%-10s%-10s%-7s", "Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < PeopleCount; i++) {
            System.out.printf("%-13d%-10d%-10d%-10d%-10d%-7d",SurName[i],Quatrum[i][0],Quatrum[i][1],Quatrum[i][2],Quatrum[i][3],Quatrum[i][4] );
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("%10s%d","Итого",Itogo);
        System.out.printf("%10s%.4d","Средняя",SrZar);
    }
}
