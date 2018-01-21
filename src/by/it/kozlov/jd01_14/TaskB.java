package by.it.kozlov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Сделать компактные методы, реализовать запись результата в файл
public class TaskB {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/kozlov/jd01_14/";
        File file = new File(path, "text.txt");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader dis =
                     new BufferedReader(
                             new FileReader(file)
                     )
        ) {
            int a;
            while ((a = dis.read()) != -1) {
                sb.append((char) a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("words=%d, punctuation marks=%d", countWord(sb), countChar(sb));

    }

    static int countChar(StringBuilder string) {
        int counter = 0;
        counter = counter + countFreePoint(string) + countSign(string);
        return counter;
    }

    static int countWord(StringBuilder string) {
        StringBuilder sb = new StringBuilder(string);
        int counter = 0;
        Pattern pattern = Pattern.compile("\\.|,|!|-|:|\\s");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) sb.replace(matcher.start(), matcher.start() + 1, " ");
        Pattern pattern1 = Pattern.compile("[A-Za-zА-Яа-яёЁ] ");
        Matcher matcher1 = pattern1.matcher(sb);
        while (matcher1.find()) counter++;
        return counter;
    }


    static int countFreePoint(StringBuilder string) {
        int counter = 0;
        Pattern pattern = Pattern.compile("\\.{3}");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) counter -= 2;
        return counter;
    }

    static int countSign(StringBuilder string) {
        int counter = 0;
        Pattern pattern = Pattern.compile("\\.|,|!|-");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) counter++;
        return counter;
    }
}
