package by.it.fyodorov.jd01_07;

public class Scalar extends  Abstractvar {
    private double value;
    Scalar(double value) {
        this.value = value;
    }
    Scalar(Scalar other){
        this.value = other.value;
    }
    Scalar(String string){
        //"8.9765"
        this.value=Double.parseDouble(string);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
