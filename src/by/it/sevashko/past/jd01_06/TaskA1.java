package by.it.sevashko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-Яё]{4,100}") ;
        Matcher matcher = pattern.matcher(Poem.text);
        StringBuilder sb = new StringBuilder(Poem.text);
        while (matcher.find()){
//            System.out.println(matcher.group());
            int position = matcher.start() + 3;
            sb.replace(position, position+1, "#");
            int len = matcher.end() - matcher.start();
            if (len > 6) {
                position = matcher.start() + 6;
                sb.replace(position, position+1, "#");
            }
        }
        System.out.print(sb);
    }
}
