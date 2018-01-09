package by.it.korobeinikov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words={};
    private static  int[] counts ={};

    private static void proccesWord (String word){
        for (int i = 0; i < words.length; i++) {
            if (words.equals(words[i])){
                counts[i]= counts[i]+1;
                return;
            }
        }
        Arrays.copyOf(words,words.length+1);
        Arrays.copyOf(counts, counts.length+1);
        counts[counts.length-1]=1;
        words[words.length-1]=word;

    }

    private static void print(){
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]+"="+ counts[i]);
        }

        }

    public static void main(String[] args){
        //System.out.println(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
            proccesWord(word);
        }
        print();
        }
    }
