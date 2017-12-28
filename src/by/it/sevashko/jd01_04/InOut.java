package by.it.sevashko.jd01_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InOut {

    static String readConsoleLine() throws IOException {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);
        String line = br.readLine();
        return line;
    }

    static double[] getArray(String line){
        line = line.trim();
        String[] lineAr = line.split(" ");
        double[] mas = new double[lineAr.length];
        for (int i = 0; i < lineAr.length; i++) {
           mas[i] = Double.parseDouble(lineAr[i]);
        }
        return mas;
    }

    static void printArray(double[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d]=%.2f ", i, arr[i]);
            if (i + 1 == arr.length) System.out.println();
        }
    }

    /**
     *
     * @param arr входной массив
     * @param name название массива, отображаемое на экране
     * @param columnCount количество элементов в строке
     */
    static void printArray(double[] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-8.2f ",name, i, arr[i]);
            if ((i + 1 ) % columnCount == 0 | i == arr.length - 1) System.out.println("");
        }
    }

    static void printArray2D(double[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%8.2f   ", arr[i][j]);
                if (j == arr[0].length - 1) System.out.println();
            }
        }
    }

    static void printArray2D(double[][] arr, String name){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%s[%d,%d]=%-8.2f   ", name, i, j, arr[i][j]);
                if (j == arr[0].length - 1) System.out.println();
            }
        }
    }
}
