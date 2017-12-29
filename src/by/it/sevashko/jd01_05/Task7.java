package by.it.sevashko.jd01_05;

public class Task7 {

    public static void main(String[] args) {
        work();
    }

    static void work(){
        int[] arrayA = new int[31];
        int lengthArrayB = 0;
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = (int)(Math.random() * (451 - 103)) + 103;
            if ((double)arrayA[i] * 0.1 > (double) i) lengthArrayB = lengthArrayB + 1;
        }
        printArray(arrayA, "A", 5);

        int[] arrayB = new int[lengthArrayB];
        int j = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if ((double)arrayA[i] * 0.1 > (double) i){
                arrayB[j] = arrayA[i];
                j = j + 1;
            }
        }
        mergeSort(arrayB);
//        printArray(arrayB, "B", 5);
    }

    static void printArray(int[] arr, String name, int columnCount){
        //Top
        System.out.print((char)9556);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 10; i++) System.out.print((char) 9552);
            System.out.print((char) 9574);
        }
        for (int i = 0; i < 10; i++) System.out.print((char) 9552);
        System.out.println((char)9559);

        for (int i = 0; i < 5; i++) System.out.printf("%s%s[%2d]=%d", (char)9553, name, i, arr[i]);
    }

    static void mergeSort(int[] array){
        int[] rm = mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            array[i] = rm[i];
        }
    }

    static int[] mergeSort(int[] array, int l, int r){
        if (l < r){
            int m = (l + r)/2;
            return merge(mergeSort(array, l, m), mergeSort(array, m+1, r));
        }
        else {
            int[] item = new int[1];
            item[0] = array[l];
            return item;
        }
    }

    static int[] merge(int[] m1, int[] m2) {
        int i = 0, j = 0, k = 0;
        int[] rm = new int[m1.length + m2.length];
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
}
