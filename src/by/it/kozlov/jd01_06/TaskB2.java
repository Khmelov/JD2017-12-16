package by.it.kozlov.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        deleteElipsis(sb);
        deleteSpace(sb);
        String[] text = newMas(sb);
        strSort(text);
        for (int i = 0; i < text.length; i++) {
            System.out.printf("%s\n", text[i]);
        }
    }

    private static StringBuilder deleteElipsis(StringBuilder sb) {
        Pattern pattern = Pattern.compile("\\.{3}|-|,|:|!|\\s");
        Matcher matcher = pattern.matcher(sb.toString());
        int coefficient = 0;
        while (matcher.find()) {
            int start = matcher.start() - coefficient;
            sb.replace(start, start + matcher.end() - matcher.start(), " ");
            coefficient = coefficient + matcher.end() - matcher.start() - 1;
        }
        return sb;
    }

    private static StringBuilder deleteSpace(StringBuilder sb) {
        Pattern pattern = Pattern.compile("\\s{2,}");
        Matcher matcher = pattern.matcher(sb.toString());
        int coefficient = 0;
        while (matcher.find()) {
            int start = matcher.start() - coefficient;
            sb.replace(start, start + matcher.end() - matcher.start(), " ");
            coefficient = coefficient + matcher.end() - matcher.start() - 1;
        }
        return sb;
    }

    private static String[] newMas(StringBuilder sb) {
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(sb.toString());
        int counter = 0;
        int coefficient = 0;
        while (matcher.find()) {
            int start = matcher.start() - coefficient;
            sb.replace(start, start + matcher.end() - matcher.start(), " ");
            coefficient = coefficient + matcher.end() - matcher.start() - 1;
            counter++;
        }
        String[] text = new String[counter];
        int counterMather = 0;
        matcher.find(0);
        for (int i = 0; i < text.length; i++) {
            text[i] = sb.substring(counterMather, matcher.end());
            text[i] = text[i].trim();
            counterMather = matcher.end();
            matcher.find();
        }
        return text;
    }

    private static void strSort(String[] text) {
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text.length - 1 - i; j++) {
                if (text[j].length() > text[j + 1].length()) {
                    String str = text[j];
                    text[j] = text[j + 1];
                    text[j + 1] = str;
                }
            }
        }
    }
}
