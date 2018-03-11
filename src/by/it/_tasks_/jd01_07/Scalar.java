package by.it._tasks_.jd01_07;

public class Scalar extends AbstractVar {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar varScalar){
        this.value=varScalar.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
