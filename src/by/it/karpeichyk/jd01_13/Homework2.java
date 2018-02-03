package by.it.karpeichyk.jd01_13;

/**
 * Created by user on 21.01.2018.
 */
public class Homework2 {
    public static void genException() {
        int n []={4,8,16,32,64,128,256,512};
        int d []={2,0,4,4,0,8};
        for (int i = 0; i <n.length ; i++) {
            try {
                System.out.println(n[i]+"/"+d[i]+"is"+n[i]/d[i]);

        }catch (ArithmeticException e){
                System.out.println("Делить на ноль нельзя!");}

            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Нет такого элемента");
                throw e;}}}}

