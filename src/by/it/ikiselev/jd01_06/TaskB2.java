package by.it.ikiselev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("([^!?(.){3}.]+[!?(.){3}.])");
        Matcher matcher=pattern.matcher(Poem.text);
       // matcher.replaceAll("\n");
        StringBuilder sb=new StringBuilder(Poem.text);
        while (matcher.find()){

        }

    }
    public static StringBuilder replaceN (StringBuilder sb){
     //   sb.
        return sb;
    }
}
