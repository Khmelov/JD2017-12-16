package by.it.karpeichyk.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 21.12.2017.
 */
public class InOut {
    public static void main(String[] args) {
        Scanner cs= new Scanner(System.in);
        double[] v = new double[10];
        System.out.println(Arrays.toString(v));


    }
    static public double[ ] getArray(String line){
        String[] v = line.split(" ");
        double [] res= new double[v.length];
        for (int i = 0; i <v.length ; i++) {
            res[i]=Double.parseDouble(v[i]);

        }
        return res;

    }
    static void  printArray (double[] v){
        for (int i = 0; i <v.length ; i++) {
        System.out.printf("[%d]=%.2f ",i,v[i]);
        }}


        static public void printArray(double[ ] v, String name, int columnCount){
        for (int i = 0; i <v.length ; i++) {
            if(i%columnCount==0){
                System.out.println();
            }
            System.out.printf("%s[% -1d]=%1.2f  ",name,i,v[i]);

        }
    }
    }

