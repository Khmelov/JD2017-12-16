package by.it.karpeichyk.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 16.01.2018.
 */
public class TaskA1 {
  private   List<Integer> gradas= new ArrayList<>();

   private void clearBad(List<Integer> grades){
        Iterator<Integer> it = grades.iterator();
        while (it.next()<4){
    while (it.hasNext()&& it.next()<4)
            it.remove();
        }
    }

    public static void main(String[] args) {
        TaskA1 instans = new TaskA1();
        for (int i = 0; i <20 ; i++) {
            instans.gradas.add((int) Math.round(Math.random()*10));
            System.out.println(instans.gradas);
            instans.clearBad(instans.gradas);
            System.out.println(instans.gradas);


        }

    }

}
