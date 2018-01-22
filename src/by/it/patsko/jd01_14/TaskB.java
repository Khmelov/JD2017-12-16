package by.it.patsko.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Вариант B. В классе TaskB нужно выполнить следующие шаги:
В файле с текстом TaskB.txt нужно подсчитать общее количество знаков препинания и слов
Вывести результат на консоль в виде одной строки:words=123, punctuation marks=15
Продублировать вывод в консоль в файл resultTaskB.txt
 */
public class TaskB {
    public static void main(String[] args) {
        int words = 0, marks = 0;
        Pattern pattern = Pattern.compile("(\\.+)|[!,:-]");
        Matcher matcher;
        String str, arrStr[];
        String path = System.getProperty("user.dir") + "/src/by/it/patsko/jd01_14/";
        try (BufferedReader br = new BufferedReader(
                new FileReader(
                        new File(path, "TaskB.txt")));
             BufferedWriter bw = new BufferedWriter(
                     new FileWriter(
                             new File(path, "resultTaskB.txt")))
        ) {
            while ((str = br.readLine()) != null) {
                arrStr = str.split("\\s-\\s|\\s");
                words += arrStr.length;
                matcher = pattern.matcher(str);
                while (matcher.find()) marks++;
            }
            System.out.println("words=" + words + ", punctuation marks=" + marks);
            bw.write("words=" + words + ", punctuation marks=" + marks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}