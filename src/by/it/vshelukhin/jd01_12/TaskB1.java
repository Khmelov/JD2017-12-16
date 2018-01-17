package by.it.vshelukhin.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        String line = sc.nextLine();
        while (!line.equals("end")) {
            text.append(line);
            text.append(" ");
            line = sc.nextLine();
        }

        Map<String,Integer> words = new HashMap<>();
        Pattern pat = Pattern.compile("[a-zA-Z']+");
        Matcher mat = pat.matcher(text);
        while (mat.find()){
            if (words.containsKey(mat.group())){
                int temp = words.get(mat.group());
                temp++;
                words.put(mat.group(),temp);
            }
            else words.put(mat.group(),1);
        }
        System.out.println(words);
    }
}
