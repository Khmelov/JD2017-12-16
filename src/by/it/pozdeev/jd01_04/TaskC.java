package by.it.pozdeev.jd01_04;

import by.it.pozdeev.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        //       Scanner sc=new Scanner(System.in);
        //       String line=sc.nextLine();
        double[] act = new double[15];
        for (int i = 0; i < act.length; i++) {
            act[i] = Math.random() * 31 - 15;
        }
        InOut.printArray(act, "V", 15);
        buildOneDimArray(act);

    }

    static void buildOneDimArray(double[] mas) {
        int j = 0, k = 0;
        //    double[] mas = InOut.getArray(line);
        //    InOut.printArray(mas, l, 5);
        double a = mas[0];
        double b = mas[mas.length - 1];
        //    Helper.sort(mas);
        mas = mergeSort(mas);
        InOut.printArray(mas, "A", 15);
        //     for (int i = 0; i <mas.length; i++) {
        //         if (mas[i]==a) j=i;
        //         if (mas[i]==b) k=i;
        //    }
        j=binarySearch(mas,a);
        k=binarySearch(mas,b);
        System.out.println("first element=" +j );
        System.out.println("last element=" + k);

    }

    public static double[] mergeSort(double[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merge(mergeSort(Arrays.copyOfRange(arr, 0, middle)), mergeSort(Arrays.copyOfRange(arr, middle, len)));
    }

    private static double[] merge(double[] arr_1, double[] arr_2) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2; // a, b - счетчики в массивах
        double[] result = new double[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (arr_1[a] > arr_2[b]) result[i] = arr_2[b++];
                else result[i] = arr_1[a++];
            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return result;
    }

    private static int binarySearch(double[] arr, double a) {
        double val = a;
        int lo = 0, hi = arr.length - 1;
        int mid = lo + (hi - lo) / 2;
        do {
            mid = lo + (hi - lo) / 2;
            if (val < arr[mid]) hi = mid;
            else if (val > arr[mid]) lo = mid;

        }
        while (val != arr[mid]);
        return mid;
    }
}
