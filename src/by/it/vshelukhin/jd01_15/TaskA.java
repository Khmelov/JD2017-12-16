package by.it.vshelukhin.jd01_15;

import java.io.*;
import java.util.Formatter;
import java.util.Random;

public class TaskA {

    static int[][] getMatrix (int row, int column){
        Random rnd = new Random();
        int[][] m = new int[6][4];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = rnd.nextInt(30)-15;
            }
        }
        return m;
    }

    static String getPath(){
        StringBuilder sbPath = new StringBuilder();
        sbPath.append(System.getProperty("user.dir"));
        sbPath.append(File.separator);
        sbPath.append("src");
        sbPath.append(File.separator);
        sbPath.append((new TaskA()).getClass().getName().replace((new TaskA()).getClass().getSimpleName(),"").replace(".",File.separator));

       return sbPath.toString();
    }

    static void writeMatrexInFile (File file, int[][] matr){
        Formatter ft = new Formatter();
        for (int[] column : matr) {
            for (int element : column) {
                ft.format("%3d " ,element);
            }
            ft.format("\n");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(ft.toString());
            System.out.println("Матрица успешно записана в файл!");
        }
        catch (Exception e){
            System.out.println("Невозможно записать в файл!");
            e.printStackTrace();
        }
    }

    static void MatrixFromFileToConsole (File file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (Exception e){
            System.out.println("Невозможно прочитать файл!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        int row = 4;
        int column = 6;
        int[][] matrix = getMatrix(row,column);

        File f = new File(getPath(), "matrix.txt");

        writeMatrexInFile(f,matrix);

        MatrixFromFileToConsole(f);
    }
}
