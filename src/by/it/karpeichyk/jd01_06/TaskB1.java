package by.it.karpeichyk.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.karpeichyk.jd01_06.Poem.text;

/*
TaskB1.
Вывести в консоль все слова текста, начинающихся согласной и заканчивающихся гласной буквой
(нужно сделать для проверки этого условия приватный метод без regex).
*/

public class TaskB1 {
   static String[] words = {};
   String[] s= new String[] {"а,е,о,и,ю,э,я,у,ё"};
    private static void processWord(String word) {
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])){
                return;}
            }

    words = Arrays.copyOf(words, words.length+1);
        words[words.length - 1] = word;}
        //System.out.print(Arrays.toString(words));}
        private  static void Change(){


        }


    public static void main(String[] args) {

   Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]");// создаем объект класса Pattern имя объекта pattern
  Matcher matcher=pattern.matcher(Poem.text);// создаем matcher
    StringBuilder sb= new StringBuilder(Poem.text);
        while (matcher.find()) {
           String word = matcher.group();
           // System.out.print(word);
           processWord(word);}

            
        }}





