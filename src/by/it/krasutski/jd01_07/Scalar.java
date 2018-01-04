package by.it.krasutski.jd01_07;

public class Scalar extends AbstractVar {
    private double value;

    public Scalar(double value){
        this.value=value;
    }

    public Scalar(Scalar scalar){
        this.value=scalar.value;
    }

    public Scalar(String strScalar){
       this.value=Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}
