package by.it.kozlov.jd01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int[][] m = new int[6][4];
        Random rnd = new Random();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = rnd.nextInt(31);
            }
        }
        //output to txt file
        String root=System.clearProperty("user.dir");
        try (
                PrintWriter writer = new PrintWriter(
                        new FileWriter(root+"\\src\\by\\it\\kozlov\\jd01_15\\matrix.txt")
                )) {
            for (int[] row : m) {
                for (int value : row) {
                    writer.printf("%3d ", value);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
