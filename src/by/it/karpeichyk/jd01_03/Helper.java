package by.it.karpeichyk.jd01_03;

/**
 * Created by user on 27.12.2017.
 */
public class Helper {

    static public double findMin(double[ ] v){
        if (0 ==v.length ) {
            return Double.MIN_VALUE;
        }else {
            Double min = v[0];
            for (double m : v) {
                if (min > m)
                    min = m;
            }
            System.out.println();
            System.out.println(min+" " );
            return min;
        }}
    static public double  findMax(double[ ] v) {
        if (0 == v.length) {
            return Double.MAX_VALUE;
        } else {
            Double max = v[0];
            for (double m : v) {
                if (max < m)
                    max = m;
            }
            System.out.println(max + " ");
            return max;
        }}
    static public void sort(double[ ] v){
        for (int i = 0; i <v.length ; i++) {
            int m = i;
            for (int j = i; j < v.length; j++) {
                if (v[m] > v[j])
                    m = j;}
            double t = v[m];
            v[m] = v[i];
            v[i] = t;}
           // System.out.print(t+" ");
            InOut.printArray(v, "massive", 4);
        }}






