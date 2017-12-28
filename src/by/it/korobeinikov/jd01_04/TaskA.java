package by.it.korobeinikov.jd01_04;

import by.it.korobeinikov.jd01_03.Helper;
import by.it.korobeinikov.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args){
        printMulTable();
        String line = "1 -0.5 12 32 -10 1.1 1.7 -3.1 -14 79";
        Scanner sc=new Scanner(System.in);
        line=sc.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d",i,j,i*j);
            }
            System.out.println();
        }
        System.out.println();
    }
    static void buildOneDimArray(String line){
        double[] massive = InOut.getArray(line);
        double Buffer1 = massive[0];
        double Buffer2 = massive[massive.length-1];
        InOut.printArray(massive, "V",5);
        System.out.println();
        Helper.sort(massive);
        int b1=0;
        int b2=0;
        for (int i = 0; i < massive.length; i++) {
            if (massive[i]==Buffer1)b1=i;
        }
        for (int i = 0; i < massive.length; i++) {
            if (massive[i]==Buffer2)b2=i;
        }
        System.out.println();
        InOut.printArray(massive, "V",4);
        System.out.println();
        System.out.println("Index of first element="+b1);
        System.out.println("Index of last element="+b2);
    }
}
