package by.it.patsko.jd01_15;

import java.io.*;
import java.util.Random;

class TaskA {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix();
//        System.out.println(File.separator);
        //output to txt file

//                TaskA.class.getSimpleName()
        saveMatrix((new File(getRoot(), "matrix.txt")), matrix);
        showFile(new File(getRoot(), "matrix.txt"));
        //read file
    }
    private static int[][] generateMatrix() {
        Random rmd = new Random();
        int[][] m = new int[6][4];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = -15 + rmd.nextInt(31);
            }
        }
        return m;
    }

    private static String getRoot() {
        return System.getProperty("user.dir") +
                File.separator + "src" + File.separator +
                TaskA.class.getName().
                        replaceFirst(TaskA.class.getSimpleName(), "").
                        replace(".", File.separator);
    }

    private static void saveMatrix(File file, int[][] matrix) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(file)
        )) {
            for (int[] row : matrix) {
                for (int value : row) {
                    writer.printf("%3d ", value);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showFile(File txtFile) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(txtFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
