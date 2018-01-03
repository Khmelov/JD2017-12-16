package by.it.ikiselev.jd01_04;

import by.it.ikiselev.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
//static
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        //  double[] arr;
       buildOneDimArray(line);
          //  double[] d=new double[]{-14.456922400680195, -8.051713822905842, -13.498556542955063, 2.8830429842916097, -6.912475126115618, -8.831617683722952, 10.2700787657235, 2.182299447368436, 7.467592531566741, 11.003453365931609, 11.81940677757289, -7.806292583983632, -12.700688619398012, -11.820583645278663, -10.868152357118255};
           // mergeSort(d);
    }

    static int binarySearch(double[] array, double value) {
        int i = -1;
        int low = 0, high = array.length, mid;
        while (low < high) {
            mid = (low + high)/2; // Можно заменить на: (low + high) >>> 1, чтоб не возникло переполнение целого
            if (value == array[mid]) {
                i = mid;
                break;
            } else {
                if (value < array[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return i;
    }
    static void buildOneDimArray(String line){
        double[] arr=InOut.getArray(line);
        // InOut.printArray(arr, "V",5);
        //  double first=arr[0];
        //  double last=arr[arr.length-1];
        //  double[] copy=arr;
        mergeSort(arr);
        System.out.println(arr[0]);
        //  copy=mergeSort1(arr);
        //  InOut.printArray(copy,"V",4);
        //  int indexFirst= binarySearch(copy,first);
        //  int indexLast=binarySearch(copy, last);
        //  System.out.printf("Index of first element=%d\n",indexFirst);
        //  System.out.printf("Index of last element=%d\n",indexLast);
    }
    static void mergeSort(double[] array){
        double first=array[0];
        double last=array[array.length-1];
        array=mergeSort1(array);
        InOut.printArray(array,"V",4);
        int indexFirst= binarySearch(array,first);
        int indexLast=binarySearch(array, last);
        System.out.printf("Index of first element=%d\n",indexFirst);
        System.out.printf("Index of last element=%d\n",indexLast);
    }
    static double[] mergeSort1(double[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merge(mergeSort1(Arrays.copyOfRange(arr, 0, middle)), mergeSort1(Arrays.copyOfRange(arr, middle, len)));
    }
    static double[] merge(double[] arr_1, double[] arr_2) {
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
}
