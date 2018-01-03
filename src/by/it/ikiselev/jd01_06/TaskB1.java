package by.it.ikiselev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    static char[] vowels={'А','Е','Ё','И','О','У','Ы','Э','Ю','Я','а','е','ё','и','о','у','ы','э', 'ю','я'};

    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher matcher=pattern.matcher(Poem.text);
        StringBuilder sb=new StringBuilder(Poem.text);
        while (matcher.find()){
            String word=matcher.group();
            compare(word);
        }
    }
    private static void compare(String w){
        boolean vow=false;
        boolean con=true;
        char s=w.charAt(0);
        char e=w.charAt(w.length()-1);
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i]==s)  {con=false;}
            if (vowels[i]==e){vow=true;}
        }
        if (vow&&con){
            System.out.println(w);
        }

    }
}
