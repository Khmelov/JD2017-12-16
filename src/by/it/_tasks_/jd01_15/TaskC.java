package by.it._tasks_.jd01_15;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

public class TaskC {
    static String dir(Class cl) {
        return System.getProperty("user.dir") + "/src/" + cl.getName().replace(cl.getSimpleName(), "").replace(".", "/");
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File root = new File(dir(TaskC.class));
        while (true) {
            System.out.print(root.getCanonicalPath() + ">");
            String cmd = scanner.nextLine();
            if (cmd.equals("end"))
                break;
            if (cmd.equals("dir")) {
                File[] files = root.listFiles();
                for (File file : files) {
                    System.out.printf("%s %8d %-15s\n",
                            new Date(file.lastModified()),
                            file.length(),
                            file.getName());

                }
            }
            if (cmd.startsWith("cd ")) {
                cmd = cmd.replaceFirst("cd\\s+", "");
                System.out.println("set " + root.getAbsolutePath() + File.separator + cmd);
                File tmp = new File(root + File.separator + cmd);
                if (tmp.isDirectory())
                    root = tmp;
                else
                    System.out.println("ERROR: " + tmp.getAbsolutePath());
            }
        }
    }
}
