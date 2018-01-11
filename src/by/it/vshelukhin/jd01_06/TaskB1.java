package by.it.vshelukhin.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    static String[] words = new String[0];

    static void chek_word(String word) {
        char[] soglasnie = {'б', 'Б', 'в', 'В', 'г', 'Г', 'д', 'Д', 'ж', 'Ж', 'з', 'З', 'й', 'Й', 'к', 'К', 'л', 'Л', 'м', 'М', 'н', 'Н', 'п', 'П', 'р', 'Р', 'с', 'С', 'т', 'Т', 'ф', 'Ф', 'х', 'Х', 'ц', 'Ц', 'ч', 'Ч', 'ш', 'Ш', 'щ', 'Щ'};
        char[] glasnie = {'а', 'А', 'о', 'О', 'и', 'И', 'е', 'Е', 'ё', 'Ё', 'э', 'Э', 'ы', 'Ы', 'у', 'У', 'ю', 'Ю', 'я', 'Я'};
        char start = word.charAt(0);
        char end = word.charAt(word.length() - 1);
        if (is_lit(start, soglasnie) && is_lit(end, glasnie)) {
            words = Arrays.copyOf(words, words.length + 1);
            words[words.length - 1] = word;
        }
    }

    private static boolean is_lit(char ch, char[] mas) {
        for (int i = 0; i < mas.length; i++) {
            if (ch == mas[i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Pattern pat = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher mat = pat.matcher(Poem.text);
        while (mat.find()) {
            String word = mat.group();
            if (word.length() > 1) chek_word(word);
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}

