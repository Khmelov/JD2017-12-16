package by.it.patsko.jd01_15;

import java.io.*;
import java.util.Random;

/*
Класс TaskA
Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15.
При выводе для каждого числа нужно предусмотреть для него три знакоместа, после чисел –один пробел.
Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.
 */
class TaskA {
    static int[][] generateMatrix(int cols, int rows) {
        int[][] m = new int[cols][rows];
        Random random = new Random();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = random.nextInt(31) - 15;
//                m[i][j]=(int)(Math.random()*31)-15;
            }
        }
        return m;
    }

    static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%3d ", m[i][j]);
            }
            System.out.println();
        }
    }

    static String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("user.dir"));
        sb.append(File.separator);
        sb.append("src");
        sb.append(File.separator);
        sb.append(TaskA.class.getName()
                .replace(TaskA.class.getSimpleName(), "")
                .replace(".", File.separator));
        return sb.toString();
        /*return System.getProperty("user.dir") +
                File.separator + "src" + File.separator +
                TaskA.class.getName().
                        replaceFirst(TaskA.class.getSimpleName(), "").
                        replace(".", File.separator);*/
    }

    static void writeMatrix(File file, int[][] m) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(file)
        )) {
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    writer.write(String.format("%3d ", m[i][j]));
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try (PrintWriter writer=new PrintWriter(
                new FileWriter(file)
        )){
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    writer.printf("%3d ", m[i][j]);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    static void readNShowMatrix(File file) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file)
        )) {
            String str;
            while ((str = reader.readLine()) != null) System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(6, 4);
        printMatrix(matrix);
        System.out.println();
        writeMatrix(new File(getPath(), "matrix.txt"), matrix);
        readNShowMatrix(new File(getPath(), "matrix.txt"));
    }
}
