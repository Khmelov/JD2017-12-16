package by.it.viktorbrui.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {

    public static void main(String[] args) {
        long start = System.nanoTime();
        String out = slow(Poem.text);
        long workTime1 = System.nanoTime() - start;
        System.out.println(out);
        System.out.printf("Время работы метода slow() = %d наносекунд\n", workTime1);
        start = System.nanoTime();
        out = fast(Poem.text);
        long workTime2 = System.nanoTime() - start;
        System.out.println(out);
        System.out.printf("Время работы метода fast() = %d наносекунд\n", workTime2);
        System.out.printf("fast() быстрее slow() в %d раз", workTime1/workTime2);
    }
    static String slow(String text){
        Pattern pattern = Pattern.compile("[а-яА-яё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            processWord(word);
        }
        String line = "";
        Random gen = new Random(9);
        while (line.length() < 100000){
            int num = gen.nextInt(words.length);
            line = line + " " + words[num];
        }
        return line;
    }
    static String fast(String text){
        Pattern pattern = Pattern.compile("[а-яА-яё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            processWord1(word);
        }
        StringBuilder line = new StringBuilder();
        Random gen = new Random(9);
        while (line.length() < 100000){
            int num = gen.nextInt(words1.length);
            line.append(" ");
            line.append(words1[num]);
        }
        return line.toString();
    }
    private static String[] words = {};
    private static void processWord(String word){
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])){
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
    }
    private static String[] words1 = {};
    private static void processWord1(String word) {
        for (int i = 0; i < words1.length; i++) {
            if (word.equals(words1[i])) {
                return;
            }
        }
        words1 = Arrays.copyOf(words1, words1.length + 1);
        words1[words1.length - 1] = word;
    }
}
