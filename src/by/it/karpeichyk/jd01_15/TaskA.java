package by.it.karpeichyk.jd01_15;

import java.io.*;
import java.util.Random;

/**
 * Created by user on 23.01.2018.
 */
public class TaskA {
    public static void main(String[] args) throws FileNotFoundException {
        int [][] m = new  int[6][4];
        Random rand= new Random();
        for (int i = 0; i <m.length ; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i] [j]=-15+rand.nextInt(31);
            }

        }
        // out to txt file
        String root = System.getProperty("user.dir");
        try (


                PrintWriter writer = new PrintWriter (new FileWriter(root))){


        }catch (IOException e){
            e.printStackTrace();
        }
        for (int[] row : m) {
            for (int value :row) {
                System.out.printf("%3d", value);
            }
            System.out.println();

        }
      //  BufferedReader reader=new BufferedReader(new FileReader(new File(root,"in.txt")))
    }
}
