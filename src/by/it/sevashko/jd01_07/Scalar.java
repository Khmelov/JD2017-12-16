package by.it.sevashko.jd01_07;

public class Scalar extends AbstractVar {

    private double value;

    Scalar(double value){
        this.value = value;
    }

    Scalar(Scalar other){
        this.value = other.value;
    }

    Scalar(String strScallar){
        this.value = Double.parseDouble(strScallar);
    }

    public String toString(){
        return Double.toString(value);
    }
}
