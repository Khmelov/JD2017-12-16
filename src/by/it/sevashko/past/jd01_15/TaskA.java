package by.it.sevashko.jd01_15;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public class TaskA {

    private static int[][] matrix = new int[6][4];

    public static void main(String[] args) {
        generateMatrix();
        String root = System.getProperty("user.dir");
        File file = new File(root, "/src/by/it/sevashko/jd01_15/matrix.txt");
        writeMatrix(file);
        readAndPrintMatrix(file);
    }

    private static void generateMatrix(){
        Random rnd = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -15 + rnd.nextInt(31);
            }
        }
    }

    private static void writeMatrix(File file){
        try (BufferedWriter writter = new BufferedWriter(
                new FileWriter(file))) {
            for (int[] row : matrix) {
                for (int value : row) {
                    writter.write(String.format("%3d ", value));
                }
                writter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readAndPrintMatrix(File file){
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file)
        )){
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
