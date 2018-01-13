package by.it.pozdeev.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = -Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }

    public static void sort(double[] arr) {
        InOut.printArray(arr);
        boolean flag;
        int last = arr.length - 1;
        do {
            flag = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    flag = true;
                }
            }
            last--;
        }
        while (flag);
        InOut.printArray(arr);
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double vectorAns[] = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            vectorAns[i] = 0;
            for (int j = 0; j < vector.length; j++) {
                vectorAns[i] = vectorAns[i] + matrix[i][j] * vector[j];
            }
        }
        return vectorAns;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double matrixAns[][] = new double[matrixLeft.length][matrixRight[0].length];
        for (int k = 0; k < matrixLeft.length; k++) {
            for (int i = 0; i < matrixRight[0].length; i++) {
                matrixAns[k][i] = 0;
                for (int j = 0; j < matrixLeft[0].length; j++) {
                    matrixAns[k][i] = matrixAns[k][i] + matrixLeft[k][j] * matrixRight[j][i];
                }
            }
        }
        return matrixAns;
    }
}
