package by.it.ikiselev.jd01_03;

/**
 * @author iKiselev
 * @param
 *
 */
public class Helper {
    static double findMax(double[ ] arr){
        if (0==arr.length) return Double.MAX_VALUE;
        double max=arr[0];
        for (double i:arr) {
            if (i>max) max=i;
        }
return max;
    }
    static double findMin(double[ ] arr){
        if (0==arr.length) return Double.MIN_VALUE;
        double min=arr[0];
        for (double i:arr) {
            if (i<min) min=i;
        }
        return min;
   }
    public static void sort(double[ ] arr){
        boolean swap;
        int last=arr.length-1;
        do {
            swap=false;
            for (int i = 0; i < last; i++) {
                if (arr[i]>arr[i+1]) {
                    double buffer=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=buffer;
                    swap=true;
                }
                }
            last--;
        }
        while (swap);
           }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] z=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i]=z[i]+matrix[i][j]*vector[j];
            }
        }
        return z;
    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] z=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    z[i][j]=z[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }

            }
        }
        return z;
    }
}
