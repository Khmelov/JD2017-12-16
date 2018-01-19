package by.it.patsko.jd01_05;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.*;

class TaskC {
    static void taskC1() {

        double[] arrA = new double[(int) (random() * 21 + 20)];
        double x = 5.33, step = (9 - 5.33) / arrA.length;
        ArrayList<Double> smallValueNums = new ArrayList<>();

        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = cbrt(x * x + 4.5);
            if (arrA[i] > 3.5) smallValueNums.add(arrA[i]);
            x += step;

            System.out.printf("A[%- 3d] = %.5f\t", i, arrA[i]);
            if ((i + 1) % 5 == 0) System.out.println();
        }

        System.out.println("\n");

        double[] arrB = new double[smallValueNums.size()];
        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = smallValueNums.get(i);
            System.out.printf("B[%- 3d] = %.5f\t", i, arrB[i]);
            if ((i + 1) % 5 == 0) System.out.println();
        }
    }

    static void taskC2() {
        int[] A = new int[31];
        int[] B = new int[0];
        boolean f;
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (random() * 451 + 103);
            if ((A[i] * 0.1) > i) {
                int[] tmp = new int[B.length + 1];
                f = false;
                if (B.length == 0) tmp[0] = A[i];
                else {
                    for (int j = 0, k = 0; j < tmp.length; j++) {
                        if (k == B.length || !f && (A[i] < B[k])) {
                            tmp[j] = A[i];
                            f = true;
                        } else tmp[j] = B[k++];
                    }
                }
                B = tmp;
            }
        }
        System.out.println(Arrays.toString(A));
        printHorizontalOrientalTable(A, 4);
        System.out.println();
        System.out.println(Arrays.toString(B));
        printVerticalOrientalTable(B, 3);
    }

    static void printVerticalOrientalTable(int[] arr, int numOfCols) {
        System.out.println("Массив В:");
        printTableTop(numOfCols);

        for (int i = 0; i < arr.length / numOfCols + 1; i++) {
//            if (i == 0 || i % 5 == 0)
            printCellTop(numOfCols);
            System.out.print("\n\u2502");

            for (int j = 0; j < numOfCols; j++) {
                if ((i + j * (arr.length / numOfCols + 1)) >= arr.length) printEmptyCell();
                else
                    System.out.printf("\u2502A[%- 3d] = %d\u2502", i + j * (arr.length / numOfCols + 1), arr[i + j * (arr.length / numOfCols + 1)]);
            }
            printCellBottom(numOfCols);
        }
        printTableBottom(numOfCols);
    }

    static void printHorizontalOrientalTable(int[] arr, int numOfCols) {
        System.out.println("Массив A:");
        printTableTop(numOfCols);
        for (int i = 0; i < arr.length; ) {
            if (i == 0 || i % numOfCols == 0) {
                printCellTop(numOfCols);
                System.out.print("\n\u2502");
            }
            for (int j = 0; j < numOfCols; j++) {
                if (i == arr.length) printEmptyCell();
                else System.out.printf("\u2502A[%- 3d] = %d\u2502", i, arr[i++]);

            }
            if (i == arr.length || i % numOfCols == 0) {
                printCellBottom(numOfCols);
            }
        }
        printTableBottom(numOfCols);
    }

    static void printHorizontalLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("\u2500");//горизонтальная линия ─
        }
    }

    static void printTableTop(int numOfCols) {
        System.out.print("\u250c");//левый верхний угол ┌
        printHorizontalLine(numOfCols * 16);
        System.out.println("\u2510");//правый верхний угол ┐
    }

    static void printTableBottom(int numOfCols) {
        System.out.print("\u2514");//левый нижний угол
        printHorizontalLine(numOfCols * 16);
        System.out.print("\u2518");//правый нижний угол
    }

    static void printCellTop(int numOfCols) {
        System.out.print("\u2502");
        for (int i = 0; i < numOfCols; i++) {
            System.out.print("\u250c");
            printHorizontalLine(14);
            System.out.print("\u2510");
        }
        System.out.print("\u2502");
    }

    static void printCellBottom(int numOfCols) {
        System.out.print("\u2502\n\u2502");
        for (int i = 0; i < numOfCols; i++) {
            System.out.print("\u2514");//левый нижний угол
            printHorizontalLine(14);
            System.out.print("\u2518");//правый нижний угол
        }
        System.out.println("\u2502");
    }

    static void printEmptyCell() {
        System.out.printf("\u2502%12c\u2502", ' ');
    }

    /*public static void main(String[] args) {
        taskC2();
    }*/
}
