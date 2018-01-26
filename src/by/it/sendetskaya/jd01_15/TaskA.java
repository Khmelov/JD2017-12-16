package by.it.sendetskaya.jd01_15;

import java.io.*;
import java.util.Random;

//Созда тематрицу6строкна4столбцаизцелыхслуча ныхчиселот-15до15включительно.
// Выведите матрицу в текстовы  фа л matrix.txt, расположенны  в папке задания jd01_15.
// При выводе для каждого числа нужно предусмотреть для него три знакоместа, после чисел
// – один пробел.
// Прочита те фа л и покажите его в консоли. Класс Scanner использовать нельзя.
public class TaskA {

    public static void main(String[] args) {

        int m [][]=generateMatrix();

        String path=getRoot();
        File mFile=new File(path,"matrix.txt");

        saveMatrix(mFile,m);

        showFile(mFile);
    }

    private static int[][] generateMatrix()
    {
        int [][] m=new int[6][4];
        Random random=new Random();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j]=random.nextInt(31)-15;
            }
        }
        return m;
    }

    private static String getRoot()
    {
        String path=System.getProperty("user.dir")+
                File.separator+"src"+
                File.separator+
                TaskA.class.getName()
                        .replace(TaskA.class.getSimpleName(),"")
                        .replace(".", File.separator);
        return path;

    }

    //output to txt file
    private static void saveMatrix(File file,int [][]m)
    {
        try (
                PrintWriter writer=new PrintWriter(
                        new FileWriter(file)
                )) {
            for (int[] row : m) {
                for (int value : row) {
                    writer.printf("%3d ", value);
                }
                writer.println();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //read to console
    private static void showFile(File txtFile)
    {
        try (
                BufferedReader reader=new BufferedReader(
                        new FileReader(
                                txtFile
                        ))) {
            String line;
            while ((line=reader.readLine())!=null)
            {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
