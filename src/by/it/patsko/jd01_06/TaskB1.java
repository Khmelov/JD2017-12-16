package by.it.patsko.jd01_06;

/*
TaskB1.
Вывести в консоль все слова текста, начинающихся согласной и заканчивающихся гласной буквой
(нужно сделать для проверки этого условия приватный метод без regex).
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        String word;
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(sb);
        while (m.find()) {
            word = m.group();
            System.out.print(checkWord(word) ? word + " " : "");
        }
    }

    private static boolean checkWord(CharSequence word) {
        char[] vowel = {'а', 'А', 'е', 'Е', 'ё', 'Ё', 'и', 'И', 'о', 'О', 'у', 'У', 'ы', 'Ы', 'э', 'Э', 'ю', 'Ю', 'я', 'Я',};
        for (char ch : vowel) {
            if (word.charAt(0) == ch) return false;
        }
        for (char ch : vowel) {
            if (word.charAt(word.length() - 1) == ch) return true;
        }
        return false;
    }
}
