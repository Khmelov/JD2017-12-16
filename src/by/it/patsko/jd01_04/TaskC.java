package by.it.patsko.jd01_04;

/**
 * Created by user on 23.12.2017.
 */
public class TaskC {
    public static void main(String[] args) {
        String line = "123 99 88 77 66 5 4 3 1 0 2";
        buildOneDimArray(line);
    }

//    static int find(double[] arr, double value) {
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == value) return i;
//        }
//        return -1;
//    }

    static void buildOneDimArray(String line) {
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr, "V", 5);
        double first = arr[0];
        double last = arr[arr.length - 1];
//        Helper.sort(arr);
        mergeSort(arr);
        InOut.printArray(arr, "V", 4);
        int indexFirst = binarySearch(arr, first);
        int indexLast = binarySearch(arr, last);
        System.out.printf("Index of first element=%d\nIndex of last element=%d", indexFirst, indexLast);
    }

    static void mergeSort(double[] array) {
        double[] result = mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            array[i] = result[i];
        }
    }

    static double[] mergeSort(double[] array, int l, int r) {
        if (l == r) {
            double[] result = new double[1];
            result[0] = array[l];
            return result;
        }
        int m = (l + r) >>> 1;
        return merge(mergeSort(array, l, m), mergeSort(array, m + 1, r));
    }

    static double[] merge(double[] a, double[] b) {
        double[] result = new double[a.length + b.length];
        int indA = 0, indB = 0;
        for (int i = 0; i < result.length; i++) {
            if (indA == a.length && indB != b.length) result[i] = b[indB++];
            else if (indB == b.length && indA != a.length) result[i] = a[indA++];
            else if (a[indA] < b[indB]) result[i] = a[indA++];
            else result[i] = b[indB++];
        }
        return result;
    }
    static int binarySearch(double[ ] array, double value){
        int l=0, r=array.length-1, m;
        while (l<=r){
            m=(l+r)>>>1;
            if(array[m]==value) return m;
            else if(value<array[m]) r=--m;
            else l=++m;
        }
        return -1;
    }
}
