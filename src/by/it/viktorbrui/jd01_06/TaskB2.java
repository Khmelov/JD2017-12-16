package by.it.viktorbrui.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        replaceSymbols(text);
        String[] sentences = text.toString().trim().split("[!?.]+[ ]*");
        for (int i = 0; i < sentences.length; i++){
            sentences[i] = sentences[i].trim();
            processNumber(sentences[i].length());
        }
        Arrays.sort(lengths);
        for (int length : lengths){
            for (String sentence : sentences){
                if (sentence.length() == length) System.out.println(sentence);
            }
        }
    }
    private static void replaceSymbols(StringBuilder text){
        Pattern pattern = Pattern.compile("[.]{3}[ ]*|[,][ ]*|[ ]*\n|[ ][-][ ]");
        Matcher matcher = pattern.matcher(text);
        int pos = 0;
        while (matcher.find(pos)){
            pos = matcher.start();
            text.replace(matcher.start(), matcher.end() , " ");
        }
    }
    private static int[] lengths = {};
    private static void processNumber(int number){
        for (int j = 0; j < lengths.length; j++) {
            if(lengths[j] == number) return;
        }
        lengths = Arrays.copyOf(lengths, lengths.length+1);
        lengths[lengths.length-1] = number;
    }
}
