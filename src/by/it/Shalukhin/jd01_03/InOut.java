package by.it.Shalukhin.jd01_03;

import java.util.Arrays;

public class InOut {
    public static double[] getArray (String line){
        String line_copy = line.trim();
        String[] elem_line = line_copy.split(" ");
        double[] elem_doub = new double[elem_line.length];
        for (int i=0; i<elem_doub.length;i++){
            elem_doub[i] = Double.parseDouble(elem_line[i]);
        }
        return elem_doub;
    }

    public static void printArray (double[] arr){
        for (double v : arr) {
            System.out.printf("%5.2f ",v);
        }
    }

    public static void printArray (double[] arr, String name, int columnCount){
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%.2f   ",name,i,arr[i]);
            if (((i+1)%columnCount == 0) || i == arr.length-1) System.out.println();
        }
    }
}
