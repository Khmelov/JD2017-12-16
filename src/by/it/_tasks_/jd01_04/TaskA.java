package by.it._tasks_.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        buildOneDimArray(new Scanner(System.in).nextLine());
    }

    private static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void buildOneDimArray(String line){
        String[] s=line.trim().split(" ");
        double[] d=new double[s.length];
        for (int i = 0; i <s.length ; i++) {
            d[i]=Double.parseDouble(s[i]);
        }
        InOut.printArray(d,"V",5);
        double first=d[0];
        double last=d[d.length-1];
        Helper.sort(d);
        InOut.printArray(d,"V",4);
        System.out.println("Index of first element="+ Arrays.binarySearch(d,first));
        System.out.println("Index of last element="+ Arrays.binarySearch(d,last));
        System.out.println();
    }
}
