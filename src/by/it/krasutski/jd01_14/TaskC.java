package by.it.krasutski.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class TaskC {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/by/it/krasutski/";
        File directory = new File(path);
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(
                        new File(path + "jd01_14/", "resultTaskC.txt")))
        ) {
            System.out.println("dir:..");
            String content = getDirectory(Objects.requireNonNull(directory.listFiles()));
            System.out.print(content);
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getDirectory(File[] files) {
        StringBuilder sb = new StringBuilder();
        for (File file : files) {
            if (file.isDirectory()) {
                sb.append("dir:");
                sb.append(file.getName());
                sb.append(getDirectory(Objects.requireNonNull(file.listFiles())));
                sb.append("------------------------------------------------\n");
            } else if (file.isFile()) {
                sb.append("file:");
                sb.append(file.getName()).append("\n");
            }
        }
        return sb.toString();
    }
}
