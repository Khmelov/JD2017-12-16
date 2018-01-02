package by.it.sevashko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        replaceSymbols(text);
        String[] sentenses = text.toString().trim().split("[!?.]+[ ]*");
        for (int i = 0; i < sentenses.length; i++){
            sentenses[i] = sentenses[i].trim();
            processNumber(sentenses[i].length());
        }
        Arrays.sort(lengths);
        for (int lenght : lengths){
            for (String sentense : sentenses){
                if (sentense.length() == lenght) System.out.println(sentense);
            }
        }
    }

    private static void replaceSymbols(StringBuilder text){
        Pattern pattern = Pattern.compile("[.]{3}[ ]*|[,][ ]*|[ ]*\n|[ ][-][ ]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            text.replace(matcher.start(), matcher.end() , " ");
            matcher.reset(text);
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
