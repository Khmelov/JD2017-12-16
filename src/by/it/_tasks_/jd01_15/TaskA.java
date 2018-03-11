package by.it._tasks_.jd01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TaskA {
    static String dir(Class cl) {
        return System.getProperty("user.dir") + "/src/" + cl.getName().replace(cl.getSimpleName(), "").replace(".", "/");
    }


    public static void main(String[] args) {
        int[][] m = new int[6][4];
        Random r = new Random();
        for (int[] row : m) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -15 + r.nextInt(31);
            }
        }
        //файл вывода
        try (
                PrintWriter writer = new PrintWriter(
                        new FileWriter(dir(TaskA.class)+"matrix.txt")
                )
        ) {
            for (int[] row : m) {
                for (int value : row) {
                    writer.printf("%3d ", value);
                    System.out.printf("%3d ", value);
                }
                writer.println();
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
