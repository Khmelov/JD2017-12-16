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
        printArrayA(arrayA, "A", 5);

        int[] arrayB = new int[lengthArrayB];
        int j = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if ((double)arrayA[i] * 0.1 > (double) i){
                arrayB[j] = arrayA[i];
                j = j + 1;
            }
        }
        mergeSort(arrayB);
        printArrayB(arrayB, "B", 5);
    }

    static void printArrayA(int[] arr, String name, int columnCount){
        System.out.println("Massive A <index to rows>");
        //Top
        System.out.print((char)9556);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 11; i++) System.out.print((char) 9552);
            System.out.print((char) 9574);
        }
        for (int i = 0; i < 11; i++) System.out.print((char) 9552);
        System.out.println((char)9559);

        //body
        for (int i = 0; i < arr.length; i++){
            System.out.printf("%s %s[%2d]=%d ", (char)9553, name, i, arr[i]);
            if ((i + 1)%5 == 0) System.out.printf("%c\n", (char)9553);

            if ((i + 1)%5 == 0 && i != arr.length - 1) {
                System.out.print((char) 9568);
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 11; k++) System.out.print((char) 9552);
                    System.out.print((char) 9580);
                }
                for (int k = 0; k < 11; k++) System.out.print((char) 9552);
                System.out.println((char) 9571);
            }

            if (i == arr.length - 1){
                for (int k = 0; k < 4; k++) {
                    System.out.printf("%c", (char)9553);
                    for (int j = 0; j < 11; j++) {
                        System.out.printf("%c", ' ');
                    }
                }
                System.out.printf("%c\n", (char)9553);
            }
        }

        //bottom
        System.out.print((char)9562);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 11; i++) System.out.print((char) 9552);
            System.out.print((char) 9577);
        }
        for (int i = 0; i < 11; i++) System.out.print((char) 9552);
        System.out.println((char)9565);
    }

    static void printArrayB(int[] arr, String name, int columnCount){
        System.out.println("Massive B <index to cols>");
        //Top
        System.out.print((char)9556);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 11; i++) System.out.print((char) 9552);
            System.out.print((char) 9574);
        }
        for (int i = 0; i < 11; i++) System.out.print((char) 9552);
        System.out.println((char)9559);

        //body
        int rowCount;
        if (arr.length%5 == 0) rowCount = arr.length/5;
        else rowCount = arr.length/5 + 1;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < 5; j++) {
                if (i+j*rowCount < arr.length)System.out.printf("%s %s[%2d]=%d ", (char)9553, name, i+j*rowCount, arr[i+j*rowCount]);
                else {
                    System.out.print((char) 9553);
                    for (int k = 0; k < 11; k++) System.out.print(' ');
                }
            }
            System.out.printf("%c\n", (char)9553);
            if (i < rowCount - 1) {
                System.out.print((char) 9568);
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 11; k++) System.out.print((char) 9552);
                    System.out.print((char) 9580);
                }
                for (int k = 0; k < 11; k++) System.out.print((char) 9552);
                System.out.println((char) 9571);
            }
        }

        //bottom
        System.out.print((char)9562);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 11; i++) System.out.print((char) 9552);
            System.out.print((char) 9577);
        }
        for (int i = 0; i < 11; i++) System.out.print((char) 9552);
        System.out.println((char)9565);
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
