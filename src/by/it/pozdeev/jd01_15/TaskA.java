package by.it.pozdeev.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        Random rnd = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = -15 + rnd.nextInt(31);
            }
        }

        String path = System.getProperty("user.dir") + "/" + "src" + "/" +
                TaskA.class.getName().replace(TaskA.class.getSimpleName(), "").replaceAll("\\.", "/");
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(new File(path, "matrix.txt")))) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    writer.printf("%3d ", matrix[i][j]);
                }
                writer.println();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path, "matrix.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}