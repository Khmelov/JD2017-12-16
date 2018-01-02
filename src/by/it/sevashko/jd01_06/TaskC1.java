package by.it.sevashko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {
        String[] text = Poem.text.trim().split("\n");
        int maxLength = 0;
        for (String i : text) {
            if (i.length() > maxLength) maxLength = i.length();
        }

        StringBuilder newText = new StringBuilder();
        Pattern pattern = Pattern.compile("[ ]{1,}");
        for (String i : text){
            StringBuilder sentence = new StringBuilder(i);
            if (sentence.length() < maxLength){
                Matcher matcher = pattern.matcher(sentence);
                int findPos = 0;
                while (sentence.length() < maxLength){
                    if (matcher.find(findPos)){
                        int position = matcher.start();
                        sentence.insert(position, ' ');
                        findPos = matcher.end() + 1;
                    }
                    else {
                        findPos = 0;
                    }
                }
            }
            newText.append(sentence + "\n");
        }

        System.out.print(newText);
    }
}
