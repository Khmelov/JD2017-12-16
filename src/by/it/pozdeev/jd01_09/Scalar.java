package by.it.pozdeev.jd01_09;

public class Scalar extends Var {
    private double value;
    Scalar(double value){
        this.value=value;
    }
    Scalar(Scalar other){
        this.value=other.value;
    }
    Scalar(String string){
        this.value=Double.parseDouble(string);
    }

    public String toString(){
        return Double.toString(value);
    }
}
