package by.it.pozdeev.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        long t = System.nanoTime();
        slow(Poem.text);
        long dtSlow = (System.nanoTime() - t) / 1000;
        System.out.println("slow dt=" + dtSlow);
        t = System.nanoTime();
        fast(Poem.text);
        long dtFast = (System.nanoTime() - t) / 1000;
        System.out.println("fast dt=" + dtFast);
        System.out.println("Отличие в скорости dtSlow/dtFast="+(int)dtSlow/dtFast);
    }
    private static String slow(String text){
        String[] str = text.split("\\s+");
        for (int i = 0; i < str.length; i++) {
            str[i].trim();
        }
        String result=new String();
        Random r=new Random(1);
        do {
            result=result.concat(" "+str[r.nextInt(str.length-1)]);
        }
        while (result.length()<100000);
    return result;
    }
    private static String fast(String text){
        String[] str = text.split("\\s+");
        for (int i = 0; i < str.length; i++) {
            str[i].trim();
        }
        String result=new String();
        StringBuffer sb=new StringBuffer();
        Random r=new Random(1);
        do {
            sb=sb.append(" "+str[r.nextInt(str.length-1)]);
        }
        while (sb.length()<100000);
        return result=sb.toString();
    }
}
