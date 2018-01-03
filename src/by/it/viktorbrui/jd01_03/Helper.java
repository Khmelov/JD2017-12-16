package by.it.viktorbrui.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        if (arr.length == 0)
            return Double.MIN_VALUE;
        else {
            double min = arr[0];
            for (double m : arr) {
                if (m < min)
                    min = m;
            }
            return min;
        }
    }
    static double findMax(double[] arr) {
        if (arr.length == 0)
            return Double.MAX_VALUE;
        else {
            double max = arr[0];
            for (double m : arr) {
                if (m > max)
                    max = m;
            }
            return max;
        }
    }
    static void sort(double[] arr) {
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
    }

    static double [] mul(double[][]matrix,double[]vector){
        double[]z=new  double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                z[i]+=matrix[i][j]*vector[j];
        return z;
    }

    static double [][] mul(double[][]matrixLeft,double[][]matrixRight){
        double[][] z=new  double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    z[i][j]+=matrixLeft[i][k]*matrixRight[k][j];
        return z;
    }

    static void arrayPrint2D(double [][]m, String name){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++)
                System.out.printf(name + "[%1d,%1d]=%-5.2f  ", i, j, m[i][j]);
            System.out.println();
        }
        System.out.println();
    }
}
