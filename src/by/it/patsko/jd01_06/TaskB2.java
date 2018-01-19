package by.it.patsko.jd01_06;
/*
TaskB2.
Вывести через \n все предложения текста в порядке возрастания количества символов (!) в каждом из них.
В предложениях нужно сначала заменить все небуквенные символы и их последовательности на один пробели выполнить trim() для каждого предложения.
 */

import by.it.pozdeev.jd01_06.Poem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB2 {
    public static void main(String[] args) {
        String[] str = Poem.text.split("\\.\\n");
        /*for (int i = 0; i < str.length; i++) {
            System.out.println(i+"="+str[i]);
        }*/
        Pattern pt = Pattern.compile("[^а-яА-яёЁ]+");
        Matcher mchr;
        for (int i = 0; i < str.length; i++) {
            mchr = pt.matcher(str[i]);
            str[i] = mchr.replaceAll(" ");
            str[i] = str[i].trim();
//            System.out.println(str[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        for (String s : str) {
            System.out.println(s);
        }
    }
}
