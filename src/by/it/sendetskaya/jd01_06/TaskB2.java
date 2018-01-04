package by.it.sendetskaya.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Вывести через \n все предложения текста в порядке возрастания количества
символов (!) в каждом из них. В предложениях нужно сначала заменить все
небуквенные символы и их последовательности на один пробел и выполнить
trim() для каждого предложения.
 */
public class TaskB2 {
    private static String []strings0={};
    private static String []strings={};
    private static String str1;
    //private static int[]count={};

    public static void main(String[] args) {

        String strPattern1;
        strPattern1=workPattern1("[^А-Яа-яЁё\\.\\?\\!]+",Poem.text);

        workPattern("[^.?!]+",strPattern1);
        sortStrings();

        print();

    }

        private static void workPattern (String regexString, String text) {
            Pattern pattern = Pattern.compile(regexString);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                String str = matcher.group();
                String trim = str.trim();
                int len=matcher.end()-matcher.start();
                processWord(trim,len);
            }

        }
            private static String workPattern1 (String regexString, String text)
            {
                Pattern pattern1 = Pattern.compile(regexString);
                Matcher matcher1 = pattern1.matcher(text);

                while (matcher1.find()) {
                    str1 = matcher1.group();

                    str1 = matcher1.replaceAll(" ");
                    str1.trim();

                    processWord1(str1);
                }
                return str1;
            }

    private static void processWord (String str, int len)
    {
            strings = Arrays.copyOf(strings, strings.length + 1);
            strings[strings.length - 1] = str;

//        count = Arrays.copyOf(count, count.length + 1);
//        count[count.length - 1] = len;
    }

    private static void processWord1 (String str)
    {
        strings0 = Arrays.copyOf(strings0, strings0.length + 1);
        strings0[strings0.length - 1] = str;
    }

    private static void sortStrings ()
    {
        for (int i = 0; i < strings.length-1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                int iLength = strings[i].length();
                int jLength = strings[j].length();

                if (iLength > jLength) {
                    String tmp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = tmp;
                }
            }
        }
    }

    private  static void print()
    {
        for (String el:strings) {
            System.out.print(el+"\n");
        }
    }
}
