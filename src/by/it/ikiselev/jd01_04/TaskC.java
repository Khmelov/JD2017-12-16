package by.it.ikiselev.jd01_04;

import by.it.ikiselev.jd01_03.InOut;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
       // Scanner sc=new Scanner(System.in);
       // String line=sc.nextLine();
       // buildOneDimArray(line);
        double[] sdr=new double[4];
        sdr[0]=120;
        sdr[1]=76;
        sdr[2]=119;
        sdr[2]=84;
        double[] sdr1=mergeSort(sdr);
        System.out.println(sdr1[0]+" "+sdr1[1]+" "+sdr1[2]+" "+sdr1[3]+" ");
        System.out.println(binarySearch(sdr1,84));

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
        double[] arr= InOut.getArray(line);
        InOut.printArray(arr, "V",5);
        double first=arr[0];
        double last=arr[arr.length-1];
        mergeSort(arr);
        InOut.printArray(arr,"V",4);
        int indexFirst= binarySearch(arr,first);
        int indexLast=binarySearch(arr, last);
        System.out.printf("Index of first element=%d\n",binarySearch(arr,first));
        System.out.printf("Index of last element=%d\n",binarySearch(arr,last));
    }
    static double[] mergeSort(double[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
     //   System.out.println("hf1");
        int middle = len / 2;
        return merge(mergeSort(Arrays.copyOfRange(arr, 0, middle)),mergeSort(Arrays.copyOfRange(arr, middle, len)));
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
     //   System.out.println("hf2");
        return result;
    }
}
