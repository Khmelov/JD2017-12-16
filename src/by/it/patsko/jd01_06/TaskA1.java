package by.it.patsko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*TaskA1.
В каждом слове текста 4-ю и 7-ю буквы заменить символом #.
Для слов короче 4 символов корректировку не выполнять.
Для слов короче 7 символов заменять только 4-ю букву.
*/

class TaskA1 {
    public static void main(String[] args) {
        System.out.println(Poem.text);
        System.out.println();

        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]{4,}") ;
        Matcher matcher=pattern.matcher(Poem.text);
        StringBuilder sb=new StringBuilder(Poem.text);
        while (matcher.find()){
            int pos=matcher.start()+3;//#4 символа в слове
            sb.replace(pos,pos+1,"#");
            int len=matcher.end()-matcher.start();
            if(len>6){
                pos=matcher.start()+6;
                sb.replace(pos,pos+1,"#");
            }
        }
        System.out.println(sb.toString());
    }
}
