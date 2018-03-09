package by.it.sevashko.jd01_04;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
//        double[] mas = {13, 48 , 646, 15, 69, 48, 48946, 45, 98};
        int n = 100000;
        double[] mas = new double[n];
        for (int i = 0; i < n; i++) {
            mas[i] = Math.random() * 100;
        }
        long start = System.currentTimeMillis();
        mergeSort(mas);
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Скорость выполнения программы mergeSort: " + timeWorkCode + " миллисекунд");
//        System.out.print(Arrays.toString(mas));

        for (int i = 0; i < n; i++) {
            mas[i] = Math.random() * 100;
        }
        start = System.currentTimeMillis();
        sort(mas);
        timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Скорость выполнения программы sort (mergeSort_v2): " + timeWorkCode + " миллисекунд");

        for (int i = 0; i < n; i++) {
            mas[i] = Math.random() * 100;
        }
        start = System.currentTimeMillis();
        Helper.sort(mas);
        timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Скорость выполнения программы Helper.sort: " + timeWorkCode + " миллисекунд");
    }

    static void mergeSort(double[] array) {
        double[] rm = mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            array[i] = rm[i];
        }
    }

    static double[] mergeSort(double[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            return merge(mergeSort(array, l, m), mergeSort(array, m + 1, r));
        } else {
            double[] item = new double[1];
            item[0] = array[l];
            return item;
        }
    }

    static double[] merge(double[] m1, double[] m2) {
        int i = 0, j = 0, k = 0;
        double[] rm = new double[m1.length + m2.length];
        while ((i < m1.length) && (j < m2.length)) {
            if (m1[i] < m2[j]) {
                rm[k] = m1[i];
                i++;
            } else {
                rm[k] = m2[j];
                j++;
            }
            k++;
        }
        while (i < m1.length) {
            rm[k] = m1[i];
            i++;
            k++;
        }
        while (j < m2.length) {
            rm[k] = m2[j];
            j++;
            k++;
        }
        return rm;
    }

    static void sort(double[] array){
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

    }
}

