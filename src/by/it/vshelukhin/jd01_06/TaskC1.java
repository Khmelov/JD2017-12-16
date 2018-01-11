package by.it.vshelukhin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String[] stroki = Poem.text.split("\n");
        for (String s : stroki) {
            System.out.println(s);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < stroki.length; i++) {
            if (stroki[i].length()>max) max = stroki[i].length();
        }
        System.out.println(max);

        for (int i = 0; i < stroki.length; i++) {
            StringBuilder sb = new StringBuilder(stroki[i]);
            Pattern pat = Pattern.compile("\\s+");
            Matcher mat = pat.matcher(sb);
            int n = max - stroki[i].length();
            int k = 0;
            while (n!=0){
                if (mat.find(k+1)) {
                    sb.replace(mat.start(),mat.end(), mat.group()+" ");
                    n--;
                    k = mat.end();
                }
                else{
                    mat.reset();
                    k=0;
                }
            }
            stroki[i] = sb.toString();
        }
        for (String s : stroki) {
            System.out.println(s);
        }
    }
}
