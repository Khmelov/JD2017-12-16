package by.it.viktorbrui.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern pattern =Pattern.compile("[а-яёА-ЯЁ]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);
        StringBuilder sb = new StringBuilder(Poem.text);
        while (matcher.find()){
            //System.out.println(matcher.group());
            int pos = matcher.start()+3;
            sb.replace(pos,pos+1,"#");
            int len = matcher.end()-matcher.start();
            if (len>6){
                pos=matcher.start()+6;
                sb.replace(pos,pos+1,"#");
            }
        }
        System.out.println(sb.toString());
    }
}
