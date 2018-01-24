package by.it.pozdeev.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/pozdeev/";
        StringBuffer sb = new StringBuffer();
        sb.append("dir:..\n");
        System.out.println("dir:..");
        try (PrintWriter outC = new PrintWriter(new FileWriter(new File(path + "jd01_14/", "resultTaskC.txt")))) {
            outC.print(showDir(path, sb));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuffer showDir(String path, StringBuffer sb) {
        File file = new File(path);
        if (file.isFile()) {
            System.out.println("file:" + file.getName());
            sb.append("file:" + file.getName() + "\n");
        } else if (file.isDirectory()) {
            sb.append("dir:" + file.getName() + "\n");
            System.out.println("dir:" + file.getName());
            File[] paths = file.listFiles();
            if (paths != null) {
                for (int i = 0; i < paths.length; i++) {
                    showDir(paths[i].getAbsolutePath(), sb);
                }
            }
        }
        return sb;
    }
}