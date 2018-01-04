package by.it.karpeichyk.jd01_02;

/**
 * Created by user on 23.12.2017.
 */
public class Vibe {
    public static void main(String[] args) {
        int mas []=new int[] {1,4,2,4,5,1,7,8,1};
        int m=mas [0];
        for (int i = 0; i < mas.length; i++) {
            if (m>mas[i]) {
                m = mas[i];}}
        //System.out.println("min значение[" + n+"] =" + m);
        for (int i = mas.length-1; i>=0; i--) {
            if(m==mas[i]) System.out.printf(" %d",i);
        }
    }}




