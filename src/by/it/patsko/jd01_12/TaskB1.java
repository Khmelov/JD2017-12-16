package by.it.patsko.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
TaskB1.
Нужно ввести с консоли текст на английском языке до строки “end”(100 и более слов).
Для каждого слова с помощью коллекций подсчитать частоту его встречаемости.
Вывести все различныеслова формате слово=частота.
Слова, отличающиеся регистром букв, считать различными. isn't или don’t –одно слово.
 */
class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[a-zA-Z']+");
//        Matcher matcher = pattern.matcher(Test_jd01_12.text);
        Matcher matcher;
        Scanner sc = new Scanner(System.in);
        String str;
        while (!(str = sc.nextLine()).equals("end")) {
            matcher = pattern.matcher(str);
            while (matcher.find()) {
//            map.put(matcher.group(),map.containsKey(matcher.group())?map.get(matcher.group())+1:1);
                if (map.containsKey(matcher.group()))
                    map.put(matcher.group(), map.get(matcher.group()) + 1);//map.put(matcher.group(),counter++);
                else map.put(matcher.group(), 1);
            }
        }

        System.out.println(map);
    }
}
