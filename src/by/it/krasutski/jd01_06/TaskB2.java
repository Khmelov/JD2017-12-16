package by.it.krasutski.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String[] str = Poem.text.split("\\.\\n");
        Pattern p = Pattern.compile("[^а-яА-яёЁ]+");
        Matcher m;
        for (int i = 0; i < str.length; i++) {
            m = p.matcher(str[i]);
            str[i] = m.replaceAll(" ");
            str[i] = str[i].trim();
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return first.length() - second.length();
            }
        });
        for (String s : str) {
            System.out.println(s);
        }
    }
}
