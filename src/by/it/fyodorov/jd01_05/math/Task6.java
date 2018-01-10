package by.it.fyodorov.jd01_05.math;

import static java.lang.Math.*;

public class Task6 {
    public static double[] getArray(){
        int n = (int)(random()*21+20);
        //int n = 28;
        double step = (9-5.33)/n;
        double [] mas = new double[n];
        double x = 5.33;
        for (int i = 0; i < mas.length; i++) {
            mas[i] = pow(x*x+4.5,(double)1/3);
            x = x + step;
        }
        return mas;
    }

    public void printArray (double[] arr, String str){
        System.out.printf("Массив %s[]:\n", str);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d] = %7.5f\t",str,i,arr[i]);
            if ((i+1)%5 == 0 || i==arr.length-1) System.out.print("\n");
        }
    }

    public double[] getEveryThridElement (double[] arr_in){
        int n = 0;
        for (double v : arr_in) {
            if (v > 3.5) n++;
        }
        double[] arr_out = new double[n];
        int i = 0;
        for (int j = 0; j < arr_in.length; j++) {
            if (arr_in[j] > 3.5){
                arr_out[i] = arr_in[j];
                i++;
            }
        }
        return arr_out;
    }

    public static double geometric (double[] arr){
        double geom = 1;
        for (double v : arr) {
            geom = geom * v;
        }
        geom = pow(geom,(double)1/arr.length);
        return geom;
    }




}
