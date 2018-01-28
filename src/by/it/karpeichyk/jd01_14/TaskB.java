package by.it.karpeichyk.jd01_14;

import java.io.*;

/**
 * Created by user on 24.01.2018.
 */
public class TaskB {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        root = root + "/src/by/it/karpeichyk/jd01_14/";
        File file = new File(root, "TaskB.txt");
        //System.out.println(file);
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream
                        (new FileInputStream(file)));
             PrintWriter out2 = new PrintWriter(new FileWriter(new File(root,"TaskB.txt"))))
        {
            System.out.println(file);
            out2.println("TaskB.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }


