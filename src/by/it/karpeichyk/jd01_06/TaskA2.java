package by.it.karpeichyk.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 30.12.2017.
 */
public class TaskA2 {
    static String[] words = {};
    static int[] counts = {};

    private static void processWord(String word) {
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                counts[i] = counts[i] + 1;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length+1);
        counts = Arrays.copyOf(counts, counts.length+1);
        words[words.length - 1] = word;
        counts[counts.length-1]=1;

    }
private static void  print(){
    for (int i = 0; i <words.length ; i++){
        System.out.println(words[i] + "=" + counts[i]);}
}

    public static void main(String[] args) {
      //  System.out.println(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            System.out.println(word);
            processWord(word);
        }
       // print();
    }
}
