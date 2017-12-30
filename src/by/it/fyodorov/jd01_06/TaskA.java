package by.it.fyodorov.jd01_06;

import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class TaskA {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("[а-яA-ЯёЁ]{4,}");
        Matcher mather=pattern.matcher(Poem.text);
        StringBuilder sb=new StringBuilder(Poem.text);
        while (mather.find()){
            int pos =mather.start()+3;
            sb.replace(pos,pos+1,"#");
            int len=mather.end()-mather.start();
            if (len>6) {
                pos=mather.start()+6;
                sb.replace(pos,pos+1,"#");
            }
        }
        System.out.println(sb.toString());
    }
}
