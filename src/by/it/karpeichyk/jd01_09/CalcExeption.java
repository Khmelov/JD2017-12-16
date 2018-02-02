package by.it.karpeichyk.jd01_09;

/**
 * Created by user on 18.01.2018.
 */
public class CalcExeption extends Exception {


    public CalcExeption(String message) {
        super(message);
    }

    public CalcExeption(String message, Throwable cause) {super(message, cause);}

    public CalcExeption(Throwable cause) {super(cause);}


}
