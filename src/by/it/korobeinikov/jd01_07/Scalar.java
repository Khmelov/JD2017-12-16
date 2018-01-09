package by.it.korobeinikov.jd01_07;

public class Scalar extends AbstractVar {

    private double value;

    Scalar(double value){
        this.value = value;
    }

    Scalar (Scalar other)
    {
        this.value=other.value;
    }

    Scalar(String strScalar){
        this.value = Double.parseDouble(strScalar);
    }

    public String toString(){
        return Double.toString(value);
    }
}
