package by.it.vshelukhin.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        double t1 = System.nanoTime();
        System.out.println(slow(Poem.text));
        double t2 = System.nanoTime();
        System.out.printf("Время работы: %.6e наносекунд\n\n",t2-t1);
        System.out.println(fast(Poem.text));
        double t3 = System.nanoTime();
        System.out.printf("Время работы: %.6e наносекунд\n\n\n",t3-t2);
        System.out.printf("StringBilder быстрее в: %f раз\n",(t2-t1)/(t3-t2));


    }

    static String slow (String text){
        String st = text;
        Pattern pat = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher mat = pat.matcher(st);
        String [] arr = new String[0];
        while (mat.find()){
            arr = Arrays.copyOf(arr, arr.length+1);
            arr[arr.length-1] = mat.group();
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println("i="+i+" :"+arr[i]);
//        }
        long n = 0;
        String result = "";
        Random rnd = new Random(100);
        while (n<100000){
            result = result + " " + arr[rnd.nextInt(arr.length)];
            n = result.length();
        }

        System.out.println(result.length());

        return result;
    }

    static String fast (String text){
        String st = text;
        Pattern pat = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher mat = pat.matcher(st);
        String [] arr = new String[0];
        while (mat.find()){
            arr = Arrays.copyOf(arr, arr.length+1);
            arr[arr.length-1] = mat.group();
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println("i="+i+" :"+arr[i]);
//        }
        long n = 0;
        StringBuilder result = new StringBuilder("");
        Random rnd = new Random(100);
        while (n<100000){
            result.append(" "+arr[rnd.nextInt(arr.length)]);

            n = result.length();
        }
        System.out.println(result.length());

        return result.toString();
    }
}
