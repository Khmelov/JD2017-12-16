package by.it.pozdeev.jd01_06;

import by.it.pozdeev.jd01_03.Helper;
import by.it.pozdeev.jd01_03.InOut;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String[] str = Poem.text.split("\\.\\.\\.|\\.|\\?|!");
        Pattern pattern = Pattern.compile("\\n");
        Matcher matcher;
        for (int i = 0; i < str.length; i++) {
            matcher = pattern.matcher(str[i]);
            str[i] = matcher.replaceAll(" ");
            str[i] = str[i].trim();
        }
        pattern = Pattern.compile("\\p{Blank}-\\p{Blank}|:\\p{Blank}|,\\p{Blank}");
        for (int i = 0; i < str.length; i++) {
            matcher = pattern.matcher(str[i]);
            str[i] = matcher.replaceAll(" ");
            str[i] = str[i].trim();
        }
        int [][] map=new int [str.length][str.length];
        for (int i = 0; i < str.length; i++) {
            map[i][0]=i;
            map[i][1]=str[i].length();
        }
        map= sort(map);
        int a=0;
        String[] result= new String[str.length];
            for (int i = 0; i < str.length; i++)
               result[i]=str[map[i][0]];
        for (int i = 0; i < str.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[][] sort(int[][] arr) {
        boolean flag;
        int last = arr.length - 1;
        do {
            flag = false;
            for (int i = 0; i < last; i++) {
                if (arr[i][1] > arr[i + 1][1]) {
                    int buffer = arr[i][1];
                    arr[i][1] = arr[i + 1][1];
                    arr[i + 1][1] = buffer;
                    buffer = arr[i][0];
                    arr[i][0] = arr[i + 1][0];
                    arr[i + 1][0] = buffer;
                    flag = true;
                }
            }
            last--;
        }
        while (flag);
        return arr;
    }


}
