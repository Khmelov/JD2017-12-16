package by.it.viktorbrui.jd01_04;

public class Helper {

    public static double findMax(double[] arr){
        if (0 == arr.length){
            return Double.MAX_VALUE;
        }else {
            double max = arr[0];
            for (int i = 1; i < arr.length; i++){
                if (max < arr[i]) max = arr[i];
            }
            return max;
        }
    }
    public static double findMin(double[] arr){
        if (0 == arr.length){
            return Double.MIN_VALUE;
        }else {
            double min = arr[0];
            for (int i=1; i < arr.length; i++){
                if (min > arr[i]) min = arr[i];
            }
            return min;
        }
    }
    static void sort(double[] arr){
        boolean swap;
        double last = arr.length-1;
        do {
            swap = false;
            for (int j = 0; j < last; j++) {
                if (arr[j] > arr[j+1]){
                    double buffer = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        System.out.println("отсортированный массив");;
        printMas(arr);
    }
    public static void printMas (double[]arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
            System.out.println();
        }
    }
}
