package by.it.kozlov.jd01_15;

import java.io.File;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    static StringBuilder sb = new StringBuilder("C:/Users/skynet/IdeaProjects/JD2017-12-16/src/by/it/kozlov/jd01_15/");

    public static void main(String[] args) {
        System.out.println("Содержимое папки " + sb + "\n");
        Scanner sc = new Scanner(System.in);
        String str;
        while (!(str = sc.nextLine()).equals("end")) {

            if (str.equals("dir")) {
                File file = new File(sb.toString());
                System.out.println("Содержимое папки " + sb + "\n");
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    Date dt = new Date(files[i].lastModified());
                    System.out.print(dt + "    ");
                    System.out.print(files[i].isDirectory() ? "<DIR>" : "");
                    System.out.printf("%9d %s\n", files[i].length(), files[i].getName());
                }
            } else if (str.equals("cd ..")) {
                lastDir();
                System.out.println("Содержимое папки " + sb + "\n");
            } else {
                nextDir(str);
                System.out.println("Содержимое папки " + sb + "\n");
            }
        }
    }

    static private void lastDir() {
        int start = 0;
        Pattern pattern = Pattern.compile("/[A-Za-zА-Яа-яёЁ0-9]");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            start = matcher.start();
        }
        sb.delete(start + 1, sb.length());
    }

    static private void nextDir(String string) {
        string = string.replace("cd ", "");
        int leight = sb.length();
        sb.append(string+"/");
        File file = new File(sb.toString());
        if (!file.isDirectory()) {
            System.out.println("Не правильное имя дериктории");
            sb.delete(leight, sb.length());
        }
    }

}
