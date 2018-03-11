package by.it._tasks_.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String line;
        Pattern p = Pattern.compile("[a-zA-Zа-яА-ЯёЁ']+");
        while (!(line = scanner.nextLine()).equals("end")) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                String w = m.group();
                if (map.containsKey(w))
                    map.put(w, map.get(w) + 1);
                else
                    map.put(w, 1);
            }
        }
        System.out.println(map);
//        for (Map.Entry<String,Integer> pair:map.entrySet())
//            System.out.printf(".include(\"%s=%s\")\n",pair.getKey(),pair.getValue());

    }
}
