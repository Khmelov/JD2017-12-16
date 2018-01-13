package by.it.pozdeev.jd01_04;

import by.it.pozdeev.jd01_03.Helper;
import by.it.pozdeev.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        printMulTable();
        System.out.println();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);

            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        int j=0,k=0;
        String l = "V";
        double[] mas = InOut.getArray(line);
        InOut.printArray(mas, l, 5);
        double a=mas[0];
        double b=mas[mas.length-1];
        Helper.sort(mas);
        InOut.printArray(mas,l,4);
        for (int i = 0; i <mas.length; i++) {
            if (mas[i]==a) j=i;
            if (mas[i]==b) k=i;
        }
        System.out.println("first element="+j);
        System.out.println("last element="+k);

    }
}
