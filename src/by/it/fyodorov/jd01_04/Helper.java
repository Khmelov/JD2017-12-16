package by.it.fyodorov.jd01_04;

public class Helper {
    public static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        if (arr.length == 0) return -min;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    public static double findMax(double[] arr) {
        double max = -Double.MAX_VALUE;
        if (arr.length == 0) return -max;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static void sort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static double[] mul(double[][] matrix, double[] vector) {
        double[] rezult_vect = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum = sum + matrix[i][j] * vector[j];
            }
            rezult_vect[i] = sum;
        }
        return rezult_vect;
    }

    public static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] rezult_matrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < matrixRight.length; k++) {
                    sum = sum + matrixLeft[i][k] * matrixRight[k][j];
                }
                rezult_matrix[i][j] = sum;
            }
        }
        return rezult_matrix;
    }


}
