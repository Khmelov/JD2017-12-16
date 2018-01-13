package by.it.karpeichyk.jd01_08;

/**
 * Created by user on 09.01.2018.
 */
public class Extern extends Student {
    public void independentWork() {
        System.out.println("Занимался самостоятельно");
    }

    @Override
    public boolean writing() {

        boolean result = super.writing();
        if (result) {
            System.out.println("Заочник \n" + this);
        }
        return result;
    }

    @Override
    public boolean sleep(String state) {
        setStudy(state);
        boolean result =super. sleep();
        if (result) {
            System.out.println("Студент \n" + this);
        }
        return result;
    }
}





