package by.it.karpeichyk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 30.12.2017.
 */
public class TaskA1 {
    public static void main(String[] args) {
        //System.out.println(Poem.text);
        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]{4,}");// создаем объект класса Pattern имя объекта pattern
        Matcher matcher=pattern.matcher(Poem.text);// создаем matcher
        StringBuilder sb= new StringBuilder(Poem.text);//создаем объект класса StringBuilder
        while (matcher.find()){
             System.out.println(matcher.group());
            int pos= matcher.start()+3;
            sb.replace(pos,pos+1,"#");
            int lrn=matcher.end()-matcher.start();
            if (lrn>6){
                pos=matcher.start()+6;
                sb.replace(pos,pos+1,"#");
            }
        }
       System.out.println(sb.toString());
    }
}
