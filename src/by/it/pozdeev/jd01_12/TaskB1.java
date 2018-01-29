package by.it.pozdeev.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        Scanner sc=new Scanner(System.in);
        String str;
        Pattern pattern= Pattern.compile("[a-zA-Z']+");
        Matcher matcher;
        while (!(str=sc.next()).equals("end")){
            matcher = pattern.matcher(str);
            while (matcher.find()){
                    if (words.containsKey(matcher.group()))
                        words.put(matcher.group(), words.get(matcher.group())+1);
                    else words.put(matcher.group(), 1);
                }
            }
        System.out.println(words);
        }
    }

