package by.it.krasutski.jd01_04;

import java.util.Arrays;

public class TaskC {

    public static void main(String[] args) {
        double[] arr = {1,2,-3,1,6,76,-16,4.1};
        String line="1 2 3 4 5 7.7 -1";
        mergeSort(arr);
        buildOneDimArray(line);
    }

    static void mergeSort(double[] array) {
        if (array.length >= 2) {
            double[] left = Arrays.copyOfRange(array, 0, array.length / 2);
            double[] right = Arrays.copyOfRange(array, array.length / 2, array.length);
            mergeSort(left);
            mergeSort(right);
            for (int i = 0, j = 0, k = 0; i < left.length || j < right.length; k++) {
                if (i >= left.length || (j < right.length && left[i] > right[j]))
                    array[k] = right[j++];
                else
                    array[k] = left[i++];
            }
            printArray(array);
        }
    }

    static void printArray(double[] array){
        for (double a : array) System.out.print(a + " ");
        System.out.println();
    }

    static int binarySearch(double[ ] array, double value){
        int left = 0;
        int right = array.length;

        while (true)
        {
            int mid = left + (right - left) / 2;

            if (array[mid] == value)
                return mid;

            if (array[mid] > value)
                right = mid;
            else
                left = mid + 1;
        }
    }

    public static void buildOneDimArray(String line){
        double[] arr=InOut.getArray(line);
        InOut.printArray(arr,"V",5);
        double first=arr[0];
        double last=arr[arr.length-1];
        mergeSort(arr);
        InOut.printArray(arr,"V",4);
        System.out.printf("Index of first element=%d\n",binarySearch(arr,first));
        System.out.printf("Index of last element=%d\n",binarySearch(arr,last));
    }
}
