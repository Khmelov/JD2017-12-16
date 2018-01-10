package by.it.shalukhin.jd01_04;



import by.it.shalukhin.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите числа через пробел:");
        String st = sc.nextLine();
        buildOneDimArray(st);
    }

    static void buildOneDimArray(String line){
        double[] mas_d = InOut.getArray(line);
        InOut.printArray(mas_d,"V",5);
        double first_el = mas_d[0];
        double last_el = mas_d[mas_d.length-1];
        System.out.println();
        System.out.println("Первый введённый элемент = "+first_el);
        System.out.println("Последний введённый элемент = "+last_el);
        System.out.println();
        mergeSort(mas_d);
        InOut.printArray(mas_d,"V",4);
        System.out.println();
        System.out.println("Index of first element="+binarySearch(mas_d,first_el));
        System.out.println("Index of last element="+binarySearch(mas_d,last_el));
    }


    static void mergeSort_recurs (double[] array){
        double [] a = my_sort(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = a[i];
        }
    }

    static double[] my_sort (double[] arr){
        if (arr.length<2) return arr;
        double[] a = Arrays.copyOf(arr, arr.length/2);
        double[] b = Arrays.copyOfRange(arr, arr.length/2, arr.length);
        return merge(my_sort(a),my_sort(b));
    }

    static void mergeSort (double[] array){
        int mas_fragment = 1;
        while (mas_fragment<array.length){
            int sdvig = 0;
            while (sdvig<array.length){
                //System.out.println("Начало итерации");
                //System.out.println("Сортируемый массив: "+Arrays.toString(array));
                //System.out.println("Фрагмент массива = "+mas_fragment+"\tСдвиг = "+sdvig);
                if (sdvig+mas_fragment>array.length) break;
                int arr2_size;
                if (sdvig+mas_fragment+mas_fragment>array.length) arr2_size=array.length-sdvig-mas_fragment;
                else arr2_size = mas_fragment;
                double[] arr1 = Arrays.copyOfRange(array,sdvig,sdvig+mas_fragment);
                double[] arr2 = Arrays.copyOfRange(array,sdvig+mas_fragment, sdvig+mas_fragment+arr2_size);
                double[] arr3 = merge(arr1, arr2);
                //System.out.println("Первый фрагмент: "+Arrays.toString(arr1));
                //System.out.println("Второй фрагмент: "+Arrays.toString(arr2));
                //System.out.println("Фрагменты после слияния: "+Arrays.toString(arr3));
                for (int i = 0; i < arr3.length; i++) {
                    array[i+sdvig] = arr3[i];
                }
                //System.out.println("Сортируемый массив: "+Arrays.toString(array));
                //System.out.println("Конец итерации\n");
                sdvig = sdvig + mas_fragment + mas_fragment;
            }
            mas_fragment = mas_fragment*2;
        }
    }

    static double[] merge (double[] a, double[] b){
        double result[] = new double[a.length+b.length];
        int n = 0;
        int m = 0;
        for (int i = 0; i < result.length; i++) {
            if (n<a.length && m<b.length){
                if (a[n]<b[m]) result[i] = a[n++];
                else result[i] = b[m++];
            }
            else if (n<a.length) result[i] = a[n++];
            else result[i] = b[m++];
        }
        return result;
    }

    static int binarySearch (double[] array, double value){
        int i = 0;
        int j = array.length-1;
        do {
            if (array[(j+i)/2] == value) return (j+i)/2;
            if (array[(j+i)/2] < value) i = (j+i)/2+1;
            else j = (j+i)/2-1;
        } while (i!=j);
        if (array[i] == value) return i;
        else return -1;
    }
}
