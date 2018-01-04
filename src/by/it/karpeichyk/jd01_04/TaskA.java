package by.it.karpeichyk.jd01_04;

import by.it.karpeichyk.jd01_03.Helper;
import by.it.karpeichyk.jd01_03.InOut;

import java.util.Scanner;

import static by.it.karpeichyk.jd01_03.Helper.*;

/**
 * Created by user on 23.12.2017.
 */
public class TaskA {

    public static void main(String[] args) {
        Scanner cs= new Scanner(System.in);
       String line=cs.nextLine();
        double[] v = new double[10];
        printMulTable();
        buildOneDimArray(line);

    }

    static void printMulTable(){
        for (int i = 2; i <10 ; i++) {
            for(int j = 2; j< 10; j++){
                System.out.print(i+"*"+j+"="+i*j+"  ");
            }
            System.out.println(" ");
        }
    }
    static void buildOneDimArray(String line) {

        double[] v = InOut.getArray(line);
        double d= v[v.length-v.length];
        double k = v[v.length-1];
       // v[v.length-v.length]=d;
        //v[v.length-1]=k;
        InOut.printArray(v, "V", 5);
        System.out.println();
       // System.out.println(d);
       // System.out.println(k);
        Helper.sort(v);
        System.out.println();
        for (int i = 0; i <v.length ; i++){
            if( v[i]==d) {
                System.out.println("first elements= " +  i);
                break;
                }}
            for (int j = 0; j <v.length ; j++){
            if( v[j]==k) {
                System.out.println("last elements= " +j);
            break;}}
        }

    }



