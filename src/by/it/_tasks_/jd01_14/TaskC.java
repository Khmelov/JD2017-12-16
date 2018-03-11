package by.it._tasks_.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {


    static String dir(Class cl) {
        String cldir = cl.getName().replace(cl.getSimpleName(), "").replace(".", "/");
        return System.getProperty("user.dir") + "/src/" + cldir;
    }

    private static void showDir(String path, PrintWriter out2) {
        File p = new File(path);
        if (p.isFile()) {
            System.out.println("file:" + p.getName());
            out2.println("file:" + p.getName());
        } else if (p.isDirectory()) {
            System.out.println("dir:" + p.getName());
            out2.println("dir:" + p.getName());
            File[] paths = p.listFiles();
            if (paths != null)
                for (File iterator : paths) {
                    showDir(iterator.getAbsolutePath(), out2);
                }
        }
    }


    public static void main(String[] args) throws IOException {
        PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class) + "resultTaskC.txt"));
        System.out.println(dir(TaskC.class));
        showDir(dir(TaskC.class) + "..", out2);
        out2.close();
    }

}
