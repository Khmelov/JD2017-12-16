package by.it.kozlov.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double v : arr) {
            if (v < min) min = v;
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = -Double.MIN_VALUE;
        for (double v : arr) {
            if (v > max) max = v;
        }
        return max;
    }

    public static void sort(double[] arr) {
        boolean swap;
        int last = arr.length - 1;
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
            last--;
        } while (swap);
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] mul = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mul[i] = mul[i] + matrix[i][j] * vector[j];
            }
        }
        return mul;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] mul = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    mul[i][j] = mul[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return mul;
    }
}
