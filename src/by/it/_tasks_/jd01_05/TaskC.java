package by.it._tasks_.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {

    private static void printArray(double[] arr, String name, int cols) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(name);
            System.out.printf("[% -3d] =% -11.5f ", i, arr[i]);
            if ((i + 1) % cols == 0) System.out.println();
        }
        System.out.println("\n");
    } //printArray double


    private static void printBorder(int columnsNumber) {
        System.out.println("\u2551");
        System.out.print("\u2560");
        for (int j = 0; j < columnsNumber - 1; j++) {
            System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C");
        }
        System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563\n");
    } //printBorder


    private static void printArray(int[] array, String name, int columnsNumber, boolean direction) {
        int counter = 0;
        int row = 0;
        int rowsNumber;
        if (array.length % columnsNumber != 0) {
            rowsNumber = array.length / columnsNumber + 1;
        } else {
            rowsNumber = array.length / columnsNumber;
        }
//        System.out.println(array.length);
//        System.out.println(rowsNumber);
        System.out.print("\u2554");
        for (int i = 0; i < columnsNumber - 1; i++) {
            System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2566");
        }
        System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557\n");
        if (direction) {
            for (int i = 0; i < columnsNumber * rowsNumber; i++) {

                if (counter >= array.length) continue;
                System.out.print("\u2551 " + name);
                System.out.printf("[%2d] =%3d ", i, array[i]);
                if ((i + 1) % columnsNumber == 0 && i != array.length - 1) {
                    printBorder(columnsNumber);
                }
                counter++;
            }
            if (array.length % columnsNumber != 0) {
                for (int i = 0; i < columnsNumber - array.length % columnsNumber; i++) {
                    System.out.print("\u2551            ");
                }
            }
            System.out.print("\u2551");
            System.out.println();
            System.out.print("\u255a");
            for (int i = 0; i < columnsNumber - 1; i++)
            {
                System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2569");
            }
            System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255D\n");


        } else {
            for (int i = 0; i < columnsNumber * rowsNumber; i++) {

                if (counter < array.length) {
                    System.out.print("\u2551 " + name);
                    System.out.printf("[%2d] =%3d ", counter, array[counter]);
                    counter += rowsNumber;
                } else {
                    counter += rowsNumber;
                    System.out.print("\u2551            ");
                }
                if ((i + 1) % columnsNumber == 0 && i != columnsNumber * rowsNumber - 1) {
                    printBorder(columnsNumber);
                    row++;
                    counter = row;
                }
            }
            System.out.print("\u2551            ");
            System.out.println();
            System.out.print("\u255a");
            for (int i = 0; i < columnsNumber - 1; i++)
            {
                System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2569");
            }
            System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255D\n");

        }



    } //printArray int


    static void functionSix(double start, double finish, double key) {

        double[] arrA = new double[((int) (random() * 21) + 20)];
        double step = (finish - start) / arrA.length;
        double counterD = start;
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = pow(pow(counterD, 2) + 4.5, 1. / 3);
            counterD += step;
        }
        System.out.println("Массив A[]");
        printArray(arrA, "A", 5);

        int counter = 0;
        while (arrA[counter] <= key) {
            counter++;
        }
        double[] arrB = Arrays.copyOfRange(arrA, counter, arrA.length);
        System.out.println("Массив B[] из элементов массива A > " + key);
        printArray(arrB, "B", 5);

        double multB = 1;
        for (double value : arrB) {
            multB *= value;
        }
        double geometricMean = pow(multB, 1. / arrB.length);
        System.out.printf("Геометрическое среднее g массива B[] = % -9.2f\n", geometricMean);

    } //functionSix


    static void functionSeven(int start, int finish, int size, int key, int columnsMax) {

        int[] arrA = new int[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            arrA[i] = (int) (random() * (finish + 1)) + start;
            if (arrA[i] / key > i) counter++;
        }
        System.out.println("Массив A[индекс по строке]");
        printArray(arrA, "A", (int) (random() * (columnsMax)) + 1, true);

        int[] arrB = new int[counter];
        counter = 0;
        for (int i = 0; i < size; i++) {
            if (arrA[i] / key > i) {
                arrB[counter] = arrA[i];
                counter++;
            }
        }
        Arrays.sort(arrB);
        System.out.println("\nМассив B[индекс по столбцу]");
        printArray(arrB, "B", (int) (random() * (columnsMax))+1, false);

    } //functionSeven

} //TaskC


