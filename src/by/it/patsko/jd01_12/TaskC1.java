package by.it.patsko.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
TaskC1.Ввести с консоли текст до строки end.
Во входном тексте хранятся наименования некоторых объектов, по одному в строке. Строки повторяются.
Построить список C1, элементы которого содержат наименования и уникальные шифры данных объектов,
причем элементы списка должны быть упорядочены по возрастанию шифров (шифр –некоторое случайное, но гарантированно уникальное число).
Затем нужно «сжать» список C1, удаляя дублирующийся наименования объектов.
 */
class TaskC1 {

    private static double code(String str) {
        return (str.hashCode() * ((Math.random() * Double.MAX_EXPONENT) - Double.MAX_EXPONENT));
    }

    public static void main(String[] args) {
        Map<Double, String> c1 = new TreeMap<>();
        Set<Double> deleteKeySet = new HashSet<>();
        Pattern pattern = Pattern.compile("[a-zA-Z']+");
        Matcher matcher;
        Scanner sc = new Scanner(System.in);
        String str;
        while (!(str = sc.nextLine()).equals("end")) {
            matcher = pattern.matcher(str);
            while (matcher.find()) {
                double code = code(matcher.group());
                if (c1.containsValue(matcher.group())) deleteKeySet.add(code);
                c1.put(code, matcher.group());
            }
        }
        System.out.println(c1);
        Iterator<Double> iterator = deleteKeySet.iterator();
        while (iterator.hasNext()) {
            double key = iterator.next();
            if (c1.containsKey(key)) c1.remove(key);
        }
        System.out.println(c1);
    }
}
