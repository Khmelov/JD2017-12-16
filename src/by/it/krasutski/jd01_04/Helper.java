package by.it.krasutski.jd01_04;

import java.util.Arrays;

public class Helper {
    /**
     * @param arr входной массив
     * @return возвращает минимум
     */
    private static double findMin(double[] arr) {
        if (0 == arr.length) {
            return -Double.MAX_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            System.out.println(min);
            System.out.println();
            return min;
        }
    }

    /**
     * @param arr входной массив
     * @return возвращает максимум
     */
    private static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Double.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            System.out.println(max);
            System.out.println();
            return max;
        }
    }

    /**
     * @param arr входной массив
     */
    public static void sort(double[] arr) {
        boolean swap;
        double last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
        }
        while (swap);
        printMas(arr);
        System.out.println();
    }

    /**
     * @param arr входной массив
     */
    private static void printMas(double[] arr) {
        for (double m : arr) System.out.print(m + " ");
        System.out.println();
    }

    /**
     * @param matrix входная матрица
     * @param vector входной вектор
     * @return возвращет результат
     */
    private static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        printVector(result);
        System.out.println();
        return result;

    }

    /**
     * @param matrixLeft  входная матрица
     * @param matrixRight входная матрица
     * @return возвращает результат
     */
    private static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
        printMatrix(result);
        System.out.println();
        return result;
    }

    /**
     * @param vector входной массив
     */
    private static void printVector(double[] vector) {
        for (double v : vector) System.out.print(v + " ");
        System.out.println();
    }

    /**
     * @param matrixA входной двумерный массив
     */
    private static void printMatrix(double[][] matrixA) {
        for (int i = 0; i < matrixA.length; i++) {
            System.out.println(Arrays.toString(matrixA[i]));
        }
    }


}
