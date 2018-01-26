package by.it.korobeinikov.jd01_15;

import java.io.*;

public class TaskB {

/** bla… /*так не бывает* bla… //и так тоже bla… . Регулярные выражения использовать нельзя*/

private static StringBuilder sb = new StringBuilder();
    private static boolean check = false;


    private static String cancel(String string) {
        if (check) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '*') {
                    if (string.charAt(i + 1) == '/') {
                        check = false;
                        return string.substring(i + 2);
                    }
                }
            }
            return "";
        }
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '/') {
                if (string.charAt(i + 1) == '/') {
                    return string.substring(0, i);
                }
                if (string.charAt(i + 1) == '*') {
                    check = true;
                    return string.substring(0, i);
                }
            }
        }
        return string;
    }

    private static String use() {
        return System.getProperty("user.dir") +
                File.separator +
                "src" +
                File.separator +
                TaskB.class.getName()
                        .replace(TaskB.class.getSimpleName(), "")
                        .replace(".", File.separator);
    }

    public static void main(String[] args) {
        File file = new File(use(), "TaskB.java");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String string;
            while ((string = br.readLine()) != null) {
                sb.append(cancel(string+"\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file2 = new File(use(), "TaskB.txt");
        try (PrintWriter writer = new PrintWriter(file2)) {
            writer.printf(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

