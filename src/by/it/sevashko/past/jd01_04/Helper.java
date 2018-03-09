package by.it.sevashko.jd01_04;

public class Helper {

    static double findMin(double[] arr){
        double min = arr[0];
        for (double element : arr) {
            if (element < min) min = element;
        }
        return min;
    }

    static double findMax(double[] arr){
        double max = arr[0];
        for (double element : arr) {
            if (element > max) max = element;
        }
        return max;
    }

    /**
     * Производит сортировку массива по возрастанию
     * @param arr исходный массив
     */
    static void sort(double[] arr){
        double min;
        int length = arr.length;
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    min = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = min;
                    changed = true;
                }
            }
            length = length - 1;
        }
        while(changed);

    }

    /**
     * Осуществляет умножение матрицы на вектор
     * @param matrix входная матрица с размерами [m]x[n]
     * @param vector входной вектор размером [n]
     * @return результирующиц вектор размером [n]
     */
    static double[] mul(double[][] matrix, double[] vector){
        double[] multipl = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                multipl[i] = multipl[i] + matrix[i][j] * vector[j];
            }
        }
        return multipl;
    }

    /**
     * Осуществляет умножение матриц
     * @param matrixLeft Матрица слева [m]x[n]
     * @param matrixRight Матрица справа [k]x[l]
     * @return  Результирующая матрица [m]x[l]
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double[][] multipl = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int m = 0; m < matrixRight[0].length; m++) {
                for (int j = 0; j < matrixLeft[0].length; j++) {
                    multipl[i][m] = multipl[i][m] + matrixLeft[i][j] * matrixRight[j][m];
                }
            }
        }
        return multipl;
    }
}

