package by.it._tasks_.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

   private static List<Double> list = new ArrayList<>();

   private static int err = 0;

   private static Scanner sc;

    private static void readData() throws Exception {
        try {
        String str = sc.nextLine();
        System.out.println("input: "+str);
            list.add(0, Double.parseDouble(str));
        } catch (Exception e){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            err++;
            for (Double value : list) {
                System.out.print(value+" ");
            }
            System.out.println();
            if (err>=5) throw e;
        }

    }

    public static void main(String[] args) throws Exception {
        String s;
        sc =new Scanner(System.in);
         try {
             while (true) {
                 readData();
             }
         } catch (Exception e) {
            //e.printStackTrace();
            //throw e;
        }
    }
}
