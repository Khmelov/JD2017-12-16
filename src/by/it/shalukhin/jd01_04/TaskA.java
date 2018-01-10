package by.it.shalukhin.jd01_04;



import by.it.shalukhin.jd01_03.Helper;
import by.it.shalukhin.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите числа через пробел:");
        String st = sc.nextLine();
        buildOneDimArray(st);
    }
    static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d",i,j,i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line){
        double[] mas_d = InOut.getArray(line);
        InOut.printArray(mas_d,"V",5);
        double first_el = mas_d[0];
        double last_el = mas_d[mas_d.length-1];
        Helper.sort(mas_d);
        System.out.println();
        InOut.printArray(mas_d,"V",4);
        for (int i = 0; i < mas_d.length; i++) {
            if (mas_d[i]==first_el) System.out.println("Index of first element="+i);
            if (mas_d[i]==last_el) System.out.println("Index of last element="+i);
        }
    }
}
