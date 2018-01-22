package by.it.kozlov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String text = openText();
        System.out.printf("words=%d, punctuation marks=%d", countWord(text, "[A-Za-zА-Яа-яёЁ] ", 1, true), countChar(text));
        saveText(text);
    }

    static String openText() {
        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/kozlov/jd01_14/";
        File file = new File(path, "text.txt");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader(file))
        ) {
            int a;
            while ((a = bf.read()) != -1) {
                sb.append((char) a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    static void saveText(String text) {
        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/kozlov/jd01_14/";
        File file = new File(path, "resultTaskB.txt");
        try (PrintWriter bw = new PrintWriter(new BufferedWriter(new FileWriter(file)))
        ) {
            bw.println("words=" + countWord(text, "[A-Za-zА-Яа-яёЁ] ", 1, true) + ", punctuation marks=" + countChar(text));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int countChar(String string) {
        int counter = 0;
        counter = counter + countWord(string, "\\.{3}", -2, false) +
                countWord(string, "\\.|,|!|-", 1, false);
        return counter;
    }

    static int countWord(String string, String pat, int prise, boolean deletedChar) {
        int counter = 0;
        StringBuilder sb = new StringBuilder(string);
        if (deletedChar == true) {
            Pattern pattern = Pattern.compile("\\.|,|!|-|:|\\s");
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()) sb.replace(matcher.start(), matcher.start() + 1, " ");
        }
        Pattern pattern1 = Pattern.compile(pat);
        Matcher matcher1 = pattern1.matcher(sb);
        while (matcher1.find()) counter = counter + prise;
        return counter;
    }

}
