package by.it.kozlov.jd01_04;

import by.it.kozlov.jd01_03.Helper;
import by.it.kozlov.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr, "V", 5);
        double first = arr[0];
        double last = arr[arr.length - 1];
        mergeSort(arr);
        InOut.printArray(arr, "V", 4);
        System.out.printf("Index of first element=%d\n", binarySearch(arr, first));
        System.out.printf("Index of last element=%d\n", binarySearch(arr, last));
    }

    static void mergeSort(double[] array) {
        sort(array, 0, array.length - 1);
    }

    static void sort(double[] mas, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(mas, low, mid);
        sort(mas, mid + 1, high);
        double[] buf = Arrays.copyOf(mas, mas.length);
        for (int k = low; k <= high; k++)
            buf[k] = mas[k];
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                mas[k] = buf[j];
                j++;
            } else if (j > high) {
                mas[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                mas[k] = buf[j];
                j++;
            } else {
                mas[k] = buf[i];
                i++;
            }
        }
    }

    static int binarySearch(double[] array, double value) {
        return search(array, 0, array.length - 1, value);
    }

    static int search(double[] mas, int low, int high, double value) {
        int mid = low + (high - low) / 2;
        if (mas[mid] < value) return search(mas, mid + 1, high, value);
        else if (mas[mid] > value) return search(mas, low, mid - 1, value);
        else return mid;
    }
}
