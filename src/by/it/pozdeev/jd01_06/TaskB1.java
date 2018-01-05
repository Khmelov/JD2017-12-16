package by.it.pozdeev.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static char[] glasn = {'А', 'а', 'Е', 'е', 'Ё', 'ё', 'И', 'и', 'О', 'о', 'У', 'у', 'Э', 'э', 'Ы', 'ы', 'Я', 'я', 'Ю', 'ю'};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (processWord(word)) System.out.println(word);
        }
    }

    private static boolean processWord(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        boolean flag = false;
        for (int i = 0; i < glasn.length; i++) {
            if (first == glasn[i]) {
                flag = false;
                return  flag;
            }
        }
        for (int i = 0; i < glasn.length; i++) {
            if (last == glasn[i]) flag=true;
        }
        return flag;
}


}

