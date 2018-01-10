package by.it.karpeichyk.jd01_07;

/**
 * Created by user on 04.01.2018.
 */
public class Scalar extends AbstractVar {
    private double value;
     public Scalar(double value){
        this.value=value;
    }
    Scalar(Scalar other){
         this.value=other.value;
    }
    public  String toString(){
         return Double.toString(value);
    }
    Scalar(String string){
        this.value= Double.parseDouble(string);
    }
}
