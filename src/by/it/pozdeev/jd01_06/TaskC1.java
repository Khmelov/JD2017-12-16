package by.it.pozdeev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String[] str = Poem.text.split("\\n");
        int maxlen = 0;
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].trim();
            if (str[i].length() > maxlen) maxlen = str[i].length();
        }
        for (int i = 0; i < str.length; i++) {
            StringBuilder sb = new StringBuilder(str[i]);
            Pattern pattern = Pattern.compile("\\p{Blank}+");
            Matcher matcher = pattern.matcher(sb);
            int a = maxlen - str[i].length();
            int b = 0;
            while (a!= 0) {
                if (matcher.find(b + 1)) {
                    sb.replace(matcher.start(), matcher.end(), matcher.group() + " ");
                    a--;
                    b = matcher.end();
                } else {
                    matcher.reset();
                    b = 0;
                }
            }
            str[i] = sb.toString();
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }

    }


}
