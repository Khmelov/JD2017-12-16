package by.it.Shalukhin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        //System.out.println(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);
        StringBuilder sd = new StringBuilder(Poem.text);
        while (matcher.find()){
            int pos = matcher.start()+3;
            sd.replace(pos, pos+1,"#");
            if (matcher.end()-matcher.start() > 6){
                pos = matcher.start()+6;
                sd.replace(pos, pos+1, "#");
            }
        }
        System.out.println(sd);
    }
}
