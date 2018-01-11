package by.it.vshelukhin.jd01_07;

public class Scalar extends AbstractVar{
    private double value;

    Scalar(double value){
        this.value = value;
    }

    Scalar(Scalar other){
        this.value = other.value;
    }

    Scalar(String string){
        this.value = Double.parseDouble(string);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
