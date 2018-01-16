package by.it.sevashko.jd01_12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        HashMap<String, Integer> map = new HashMap<>();
        Pattern wordPattern = Pattern.compile("[A-Za-z']+");
        while (!(line = sc.nextLine()).equals("end")){
            Matcher matcher = wordPattern.matcher(line);
            while(matcher.find()) {
                String word = matcher.group();
                if (map.containsKey(word)) {
                    Integer count = map.get(word);
                    count++;
                    map.put(word, count);
                } else {
                    map.put(word, 1);
                }
            }
        }
        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry);
        }
    }
}
