package by.it.sevashko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
        String line = "1 2 56 47 232 16 14 -98 12 15 36";
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line){
        double[] mas = InOut.getArray(line);
        double first = mas[0];
        double last = mas[mas.length - 1];
        InOut.printArray(mas, "V", 5);
        mergeSort(mas);
        System.out.println();
        InOut.printArray(mas, "V", 4);
        System.out.println();
        int indexFirst = binarySearch(mas, first);
        int indexLast = binarySearch(mas, last);
        System.out.printf("Index of first element=%d\n", indexFirst);
        System.out.printf("Index of last element=%d\n", indexLast);
        System.out.println();
    }

    // Первая версия
    static void mergeSort(double[] array){
        double[] rm = mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            array[i] = rm[i];
        }
    }

    static double[] mergeSort(double[] array, int l, int r){
        if (l < r){
            int m = (l + r)/2;
            return merge(mergeSort(array, l, m), mergeSort(array, m+1, r));
        }
        else {
            double[] item = new double[1];
            item[0] = array[l];
            return item;
        }
    }

    static double[] merge(double[] m1, double[] m2){
        int i=0, j=0, k=0;
        double[] rm = new double[m1.length + m2.length];
        while ((i < m1.length) && (j < m2.length)){
            if (m1[i] < m2[j]){
                rm[k] = m1[i];
                i++;
            }
            else {
                rm[k] = m2[j];
                j++;
            }
            k++;
        }
        while (i < m1.length){
            rm[k] = m1[i];
            i++;
            k++;
        }
        while (j < m2.length){
            rm[k] = m2[j];
            j++;
            k++;
        }
        return rm;
    }

    /* вторая версия
    static void mergeSort(double[] array){
        sort(array, 0, array.length - 1);
    }

    static void sort(double[] array, int l, int r){
        int m = (l + r) / 2;
        if (l < r) {
            sort(array, l, m);
            sort(array, ++m, r);
        }
        else return;
        double[] buffer1 = Arrays.copyOfRange(array, l, m );
        double[] buffer2 = Arrays.copyOfRange(array, m , r+1);
        int i = 0, j = 0;
        while ((i < buffer1.length) && (j < buffer2.length)){
            if (buffer1[i] < buffer2[j]){
                array[l] = buffer1[i];
                i++;
            }
            else {
                array[l] = buffer2[j];
                j++;
            }
            l++;
        }
        while (i < buffer1.length) {
            array[l] = buffer1[i];
            i++;
            l++;
        }
        while (j < buffer2.length) {
            array[l] = buffer2[j];
            j++;
            l++;
        }

    }*/

    static int binarySearch(double[] array, double value){
        return binarySearch(array, value, 0, array.length - 1);
    }

    static int binarySearch(double[] array, double value, int l, int r){
        if (l <= r) {
            int m = (l + r) / 2;
            if (array[m] == value) return m;
            if (array[m] < value) return binarySearch(array, value, ++m, r);
            if (array[m] > value) return binarySearch(array, value, l, --m);
        }
        return -1;
    }
}
