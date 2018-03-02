package by.it.kozlov.jd01_14;

import java.io.*;

public class TaskC {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/kozlov/";
        File file = new File(path);
        saveText(file);
    }

    static void saveText(File file) {
        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/kozlov/jd01_14/";
        File fileOut = new File(path, "resultTaskC.txt");
        try (PrintWriter bw = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)))
        ) {
            File[] list = file.listFiles();
            for (int i = 0; i < list.length; i++) {
                System.out.println("dir:" + list[i].getName());
                bw.println("dir:" + list[i].getName());
                String[] masStr = list[i].list();
                for (int j = 0; j < masStr.length; j++) {
                    System.out.println("file:" + masStr[j]);
                    bw.println("file:" + masStr[j]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
