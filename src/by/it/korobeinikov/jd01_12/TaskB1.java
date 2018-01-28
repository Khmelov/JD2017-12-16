package by.it.korobeinikov.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[a-zA-Z']+");
        Matcher matcher;
        Scanner sc = new Scanner(System.in);
        String str;
        while (!(str=sc.nextLine()).equals("end")) {
            matcher=pattern.matcher(str);
            while (matcher.find()) {
                if (map.containsKey(matcher.group()))
                    map.put(matcher.group(), map.get(matcher.group()) + 1);
                else map.put(matcher.group(), 1);
            }
        }

        System.out.println(map);
    }
}
