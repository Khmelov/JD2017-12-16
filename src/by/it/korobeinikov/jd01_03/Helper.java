package by.it.korobeinikov.jd01_03;

public class Helper {
    public static double findMax(double[ ] arr){
        double maxMassiveElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>maxMassiveElement)maxMassiveElement=arr[i];
        }
        System.out.println(maxMassiveElement);
        return maxMassiveElement;
    }
    public static double findMin(double[ ] arr){
        double minMassiveElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<minMassiveElement)minMassiveElement=arr[i];
        }
        System.out.println(minMassiveElement);
        return minMassiveElement;
    }
    public static void sort(double[] arr){
        boolean trueMeter = false;
        do {
            trueMeter = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                double Buffer = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = Buffer;
                trueMeter = true;
            }
        }

        }
        while (trueMeter==true);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
