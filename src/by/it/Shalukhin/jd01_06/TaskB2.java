package by.it.Shalukhin.jd01_06;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        //System.out.println(Poem.text);
        Pattern pat = Pattern.compile("\\.{2,}");
        StringBuilder sb = new StringBuilder(Poem.text);

        Matcher mat = pat.matcher(sb);
        while (mat.find()){
            sb = sb.replace(mat.start(),mat.end(), ".");
            mat.reset();
        }

        pat = Pattern.compile("\\.\\s[а-яё]|\\.[а-яё]");
        mat = pat.matcher(sb);
        while (mat.find()){
            sb = sb.replace(mat.start(),mat.start()+1, "");
            mat.reset();
        }

        String[] predl = sb.toString().split("\\.|!|\\?");//
        pat = Pattern.compile("\\p{Punct}+|\\n|\\s{2,}");

        for (int i = 0; i < predl.length; i++) {
            sb = new StringBuilder(predl[i]);
            mat = pat.matcher(sb);
            while (mat.find()){
                sb = sb.replace(mat.start(),mat.end()," ");
                mat.reset();
            }
            predl[i] = sb.toString().trim();
        }
        sort(predl);
        for (String s : predl) {
            System.out.println(s);
        }
    }

    static void sort (String[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if (arr[j-1].length() > arr[j].length() ){
                    String temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }

        }
    }
}
