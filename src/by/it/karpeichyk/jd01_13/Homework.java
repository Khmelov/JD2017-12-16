package by.it.karpeichyk.jd01_13;

/**
 * Created by user on 21.01.2018.
 */
public class Homework {
    public static void main(String[] args) {


        try {
            Homework2.genException();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("фатальная ошибка");
        }
    }
}