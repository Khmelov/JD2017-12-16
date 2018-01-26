package by.it.ikiselev.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {


    public static void main(String[] args) {
        int[][] matrix = generateMatrix();
        //output to txt file
        String path = getRoot();
        File mFile = new File(getRoot(), "matrix.txt");
        saveMatrix(mFile, matrix);
        //shows file
        showFile(mFile);
    }



    private static int[][] generateMatrix() {
        int[][] m = new int[6][4];
        Random rnd = new Random();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = -15 + rnd.nextInt(31);
            }
        }
        return m;
    }

    private static String getRoot() {
        return System.getProperty("user.dir") +
                File.separator +
                "src" +
                File.separator +
                TaskA.class.getName()
                        .replace(TaskA.class.getSimpleName(), "")
                        .replace(".", File.separator);

    }


    private static void saveMatrix(File file, int[][] matrix) {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (int[] row : matrix) {
                for (int value : row) {
                    writer.printf("%3d ", value);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showFile(File txtFile) {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(txtFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

//public class TaskA {
//    public static void main(String[] args) {
//        int[][] m = new int[6][4];
//        Random rnd= new Random();
//        for (int i = 0; i < m.length; i++) {
//            for (int j = 0; j < m[i].length; j++) {
//                m[i][j]=-15+rnd.nextInt(31);
//
//            }
//        }
//
//        for (int[] row:m) {
//            for (int value:row) {
//                System.out.printf("%3d",value);
//
//
//            }
//            System.out.println();
//        }
//
//    }
//}
