package by.it._tasks_.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        buildOneDimArray(new Scanner(System.in).nextLine());
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
        mergeSort(d);
        InOut.printArray(d,"V",4);
        System.out.println("Index of first element="+ binarySearch(d,first));
        System.out.println("Index of last element="+ binarySearch(d,last));
        System.out.println();
    }

    private static int binarySearch(double[] d, double value){
        return Arrays.binarySearch(d, value);
    }

    private static void mergeSort(double[] d){
        Arrays.sort(d);
    }

}
