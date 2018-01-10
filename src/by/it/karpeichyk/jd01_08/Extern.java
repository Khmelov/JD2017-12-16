package by.it.karpeichyk.jd01_08;

/**
 * Created by user on 09.01.2018.
 */
public class Extern extends Student {
    @Override
    public boolean sleep() {
        boolean result=super.sleep();
        if (result) {
            System.out.println("Заочник \n" + this);
        }
        return result;
    }



    @Override
    public boolean learn() {
        return false;
    }
}
