package by.it.sevashko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static char[] vowels = {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'е', 'ё', 'А', 'О', 'Ы', 'И', 'Э', 'Я', 'Ю', 'Е', 'Ё'};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-яё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            compare(word);
        }
    }

    private static void compare(String word){
        char firstLetter = word.charAt(0);
        char lastLetter = word.charAt(word.length() - 1);
        boolean flag1 = true, flag2 = false;
        for (char letter : vowels){
            if (firstLetter == letter) flag1 = false;
            if (lastLetter == letter) flag2 = true;
        }
        if (flag1 && flag2) System.out.println(word);
    }
}
