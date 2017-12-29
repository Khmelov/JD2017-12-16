package by.it.patsko.jd01_03;

/**
 * @author Patsko Arkadzi
 */
public class Helper {
    /**
     * Поиск минимкма для массива double
     *
     * @param arr - одномерный массив
     * @return минимум или -Double.MAX_VALUE если массив пустой
     */
    static double findMin(double[] arr) {
        if (arr.length == 0) {
            return -Double.MAX_VALUE;
        }
        double min = Double.MAX_VALUE;
        for (double v : arr) {
            if (min > v) min = v;
        }
        return min;
    }

    /**
     * Поиск минимкма для массива double
     *
     * @param arr - одномерный массив
     * @return максимум или Double.MAX_VALUE если массив пустой
     */
    static double findMax(double[] arr) {
        if (arr.length == 0) {
            return Double.MAX_VALUE;
        }
        double max = -Double.MAX_VALUE;
        for (double v : arr) {
            if (max < v) max = v;
        }
        return max;
    }

    /**
     * Пузырьковая сортировка для массива double
     *
     * @param arr - одномерный массив
     */
    static void sort(double[] arr) {
        boolean f;
        for (int i = arr.length - 1; i >= 0; i--) {
            f = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
//                    double tmp=arr[j];
//                    arr[j]=arr[j+1];
//                    arr[j+1]=tmp;
                    f = true;
                }
            }
            if (!f) break;
        }
    }

    /**
     * Обмен двух элементов в массиве double
     *
     * @param a   - индекс элемента
     * @param b   - индекс элемента
     * @param arr - одномерный массив
     */
    static void swap(int a, int b, double[] arr) {
        Double tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    /**
     * Умножение матрицы на вектор
     *
     * @param matrix - матрица
     * @param vector - вектор
     * @return одномерный массив
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] res = new double[matrix.length];
        if (matrix[0].length != vector.length) {
            System.out.println("Ошибка");
            return res;
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                res[i] += matrix[i][j] * vector[j];
            }
        }
        return res;
    }

    /**
     * Умножение матрицы на матрицу
     *
     * @param matrixLeft  - матрица
     * @param matrixRight - матрица
     * @return двумерный массив
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] res = new double[matrixLeft.length][matrixRight[0].length];
        if (matrixLeft[0].length != matrixRight.length) {
            System.out.println("Ошибка");
            return res;
        }
        for (int k = 0; k < res.length; k++) {
            for (int l = 0; l < matrixRight[0].length; l++) {
                for (int m = 0; m < matrixRight.length; m++) {
                    res[k][l] += matrixLeft[k][m] * matrixRight[m][l];
                }
            }
        }
        return res;
    }
}
