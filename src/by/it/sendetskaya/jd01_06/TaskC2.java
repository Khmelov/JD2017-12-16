package by.it.sendetskaya.jd01_06;

import java.util.Random;

/*
TaskC2. Сформировать и вернуть в методе String slow (String text) из случа ных слов исходного текста
строку String минимум в сто тысяч символов путем конкатенации. Слова должны быть «склеены» через
один пробел. Затем:
• В методе main: определить время работы метода slow (удобно использовать System.nanoTime() или
аналог); вывести полученны  текст и время работы метода slow в милисекундах на консоль.
• Ускорить процесс с StringBuilder (сделать новы  метод String fast (String text), ВАЖНО: его итог
должен быть таким же как и в slow). В main повторить вывод.
 */
public class TaskC2 {

    static final long initTime=System.nanoTime();

    public static void main(String[] args) {

        String slow=slow("");
        System.out.println(slow);
        StringBuilder fast=new StringBuilder(fast(""));
        System.out.println(fast);
        System.out.println(slow.equals(fast));
    }

    private static String slow (String text)
    {
        long time, firstTime, secondTime;
       firstTime=System.nanoTime();
      //  System.currentTimeMillis();
        Random random=new Random(initTime);
        for (int i = 0; i < 100000/6; i++) {

           text += " " +RandomWords(random);
        }
        secondTime=System.nanoTime();
        time=secondTime-firstTime;
        System.out.println("Время работы= "+time);
return text;
    }

    private static String fast (String text)
    {
        StringBuilder sb=new StringBuilder(text);
        long time, firstTime, secondTime;
        firstTime=System.nanoTime();

        Random random=new Random(initTime);
        for (int i = 0; i < 100000/6; i++) {
            sb.append(" ");
            sb.append(RandomWords(random));
        }
        secondTime=System.nanoTime();
        time=secondTime-firstTime;
        System.out.println("Время работы= "+time);
        return sb.toString();
    }

    public static String RandomWords(Random random )
    {
            char[] word = new char[5];
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
        String randomStrings = new String(word);

        return randomStrings.toString();
    }
    
    
}
