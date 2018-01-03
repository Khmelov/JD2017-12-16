package by.it.patsko.jd01_06;
/*
TaskC2.
Сформировать и вернуть в методе String slow(String text) из случайных слов исходного текста строку String
минимум в сто тысяч символов путем конкатенации. Слова должны быть «склеены» через один пробел.

Затем:
•В методе main: определить время работы метода slow (удобно использовать System.nanoTime()или аналог);
вывести полученный текст и время работы метода slow в милисекундахна консоль.
•Ускорить процесс с StringBuilder(сделать новый метод String fast (String text),
ВАЖНО: его итог должен быть таким же как и в slow). В main повторить вывод.
 */

import java.util.Random;

public class TaskC2 {
    public static void main(String[] args) {
        long start=System.nanoTime();
        slow(Poem.text);
        long stop=System.nanoTime();
        System.out.println(stop-start);
        start=System.nanoTime();
        fast(Poem.text);
        stop=System.nanoTime();
        System.out.println(stop-start);
    }
    private static String slow(String text){
        String result="", words[];
        words=text.split("[^а-яА-ЯёЁ]+");
        Random random=new Random(0);
        while(result.length()<100000){
            result=result.concat(words[random.nextInt(words.length)]);
        }
//        System.out.println(result);
        return result;
    }
    private static String fast(String text){
        StringBuilder result=new StringBuilder();
        String words[];
        words=text.split("[^а-яА-ЯёЁ]+");
        Random random=new Random(0);
        while(result.length()<100000){
            result.append(words[random.nextInt(words.length)]);
        }
//        System.out.println(result);
        return result.toString();
    }
}
