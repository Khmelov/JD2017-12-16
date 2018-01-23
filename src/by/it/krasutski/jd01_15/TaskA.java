package by.it.krasutski.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix();
        getRoot();
        File mFile = new File(getRoot(), "matrix.txt");
        saveMatrix(mFile, matrix);
        printFile(mFile);

    }

    private static int[][] generateMatrix() {
        int[][] matrix = new int[6][4];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -15 + random.nextInt(31);
            }
        }
        return matrix;
    }

    private static String getRoot() {
        String path = System.getProperty("user.dir") +
                File.separator +
                "src" +
                File.separator +
                TaskA.class.getName()
                        .replace(TaskA.class.getSimpleName(), "")
                        .replace(".", File.separator);
        return path;
    }

    private static void saveMatrix(File file, int[][] matrix) {
        try (PrintWriter printer = new PrintWriter(file)) {
            for (int[] row : matrix) {
                for (int value : row) {
                    printer.printf("%3d ", value);
                }
                printer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFile(File txtFile){
        try (BufferedReader br = new BufferedReader(
                new FileReader(txtFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
