package by.it._tasks_.jd01_04;

import java.util.Arrays;

public class Helper {
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double d : arr)
            if (d < min) min = d;
        return min;
    }

    static double findMax(double[] arr) {
        double max = -1*Double.MAX_VALUE;
        for (double d : arr)
            if (d > max) max = d;
        return max;
    }

    static void sort(double[] sort) {
        Arrays.sort(sort);
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] res = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                res[i] = res[i] + matrix[i][j] * vector[j];
            }
        }
        return res;
    }


    static double[][] mul(double[][] l, double[][] r) {
        double[][] res = new double[l.length][r[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < r.length; k++) {
                    res[i][j] = res[i][j] + l[i][k] * r[k][j];
                }
            }
        }
        return res;
    }

}
