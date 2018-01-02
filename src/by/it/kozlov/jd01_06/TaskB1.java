package by.it.kozlov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            searchOut(word);
        }
    }

    private static void searchOut(String word) {
        String vowels = "аоиеёэыуюяАОИЕЁЭУЮЯ";
        for (int i = 0; i < vowels.length(); i++) {
            if (vowels.charAt(i) == word.charAt(word.length() - 1)) {
                for (int j = 0; j < vowels.length(); j++) {
                    if (vowels.charAt(j) == word.charAt(0)) {
                        return;
                    }
                }
                System.out.printf("%s, ", word);
            }
        }
    }
}
