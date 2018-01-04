package by.it.fyodorov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class TaskA2 {
    static String[] words={};
    static int[] counts={};
    private void processWord(String word){
        for (int i= 0; i< words.length; i++){
            if (word.equals(words[i])) {
                counts[i]= counts[i]+1;
                return;
            }
        }
        words= Arrays.copyOf(words,words.length + 1);
        counts= Arrays.copyOf(counts, counts.length+1);
        words[words.length - 1]= word;
        counts[counts.length - 1]=1;

    }
//    private static void print


    public static void main(String[] args) {
//        Pattern pattern=Pattern.compile("[а-яA-ЯёЁ]{+}");
//        Matcher mather=pattern.matcher(Poem.text);
//        while (mather.find()){
//
//        }

    }
}
