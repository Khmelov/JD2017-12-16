package by.it.korobeinikov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static String []words={};

    private static void proccesWord(String word)
    {
        char first =word.charAt(0);
        char last=word.charAt(word.length()-1);

        if (glFind(last)&&(!glFind(first))) {
            words = Arrays.copyOf(words, words.length + 1);
            words[words.length - 1] = word;
        }
    }

    private static boolean glFind(char partWord) {
        char[] gl ={'А','а','Е','е','Ё','ё','И','и','О','о','У','у','Э','э','Ы','ы','Я','я','Ю','ю'};
        boolean flagGlass=false;
        for (char i : gl) {
            if (partWord == i) {
                flagGlass=true;
            }
        }
        return flagGlass;
    }

    private  static void print()
    {
        for (String i :words) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word=matcher.group();
            proccesWord(word);
        }
        print();
    }
}

