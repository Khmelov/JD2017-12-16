package by.it.kozlov.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> list = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String str;
        while (!(str = sc.next()).equals("end")) {
            str = delChar(str);
            if (!list.containsKey(str)) {
                list.put(str, 1);
            } else {
                Integer value = list.remove(str);
                list.put(str, value + 1);
            }
        }
        System.out.println(list);
    }

    private static String delChar(String str) {
        StringBuilder sb = new StringBuilder(str);
        Pattern pattern = Pattern.compile("[,.?\"/;:()/-/—]");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            sb.replace(matcher.start(), matcher.end(), " ");
        }
        return sb.toString().trim();
    }
}
