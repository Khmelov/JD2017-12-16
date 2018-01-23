package by.it.pozdeev.jd01_14;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/pozdeev/jd01_14/";
        File file = new File(path, "text.txt");
        int i = 0;
        try (
                BufferedReader dis = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"))) {
            while (dis.readLine() != null) i++;
            dis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (
                BufferedReader dis = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                PrintWriter outB = new PrintWriter(new FileWriter(new File(path, "resultTaskB.txt")))) {

            int words = 0;
            int punkt = 0;
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < i; j++) sb.append(dis.readLine() + " ");
            Pattern patternWord = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcherWord = patternWord.matcher(sb);
            while (matcherWord.find()) words++;
            Pattern patternPunct = Pattern.compile("\\.\\.\\.|\\.|\\?|!|:|-|,");
            Matcher matcherPunct = patternPunct.matcher(sb);
            while (matcherPunct.find()) punkt++;
            punkt=punkt-1;
            System.out.println("words=" + words + ", punctuation marks=" + punkt);
            outB.print("words=" + words + ", punctuation marks=" + punkt);
            //          outB.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}