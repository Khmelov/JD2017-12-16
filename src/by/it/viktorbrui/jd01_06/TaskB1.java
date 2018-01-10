package by.it.viktorbrui.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static String []words={};

    private static char[] glas={'А','а','Е','е','Ё','ё','И','и','О','о','У','у','Э','э','Ы','ы','Я','я','Ю','ю'};

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word=matcher.group();
            processWord(word);
        }
        print();
    }

    private static void processWord (String word)
    {
        char one=word.charAt(0);
        char last=word.charAt(word.length()-1);

        if (processGlas(last)&&(!processGlas(one))) {
            words = Arrays.copyOf(words, words.length + 1);
            words[words.length - 1] = word;
        }
    }

    private static boolean processGlas (char partWord){

        boolean flagGlass=false;
        for (char el:glas) {
            if (partWord == el) {
                flagGlass=true;
            }
        }
        return flagGlass;
    }

    private  static void print(){
        for (String el:words) {
            System.out.println(el);
        }
    }

}

