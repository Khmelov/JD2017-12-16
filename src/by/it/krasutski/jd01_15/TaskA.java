package by.it.krasutski.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TaskA {

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -15 + random.nextInt(31);
            }
        }
        // output to txt file
        String path = System.getProperty("user.dir") +
                File.separator +
                "src" +
                File.separator +
                TaskA.class.getName()
                        .replace(TaskA.class.getSimpleName(), "")
                        .replace(".", File.separator);
        try (PrintWriter printer = new PrintWriter(
                new FileWriter(
                        new File(path, "matrix.txt")))) {
            for (int[] row : matrix) {
                for (int value : row) {
                    printer.printf("%3d ", value);
                    System.out.printf("%3d ", value);
                }
                printer.println();
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
