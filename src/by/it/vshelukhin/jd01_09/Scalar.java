package by.it.vshelukhin.jd01_09;

public class Scalar extends Var {
    double value;

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
    public Var add(Var other) {
        if (other instanceof Scalar){
            return new Scalar(value + ((Scalar) other).value);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            return new Scalar(value - ((Scalar) other).value);
        }
        else {
            Scalar minus = new Scalar(-1);
            return other.sub(this).mul(minus);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            return new Scalar(value * ((Scalar) other).value);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            return new Scalar(value / ((Scalar) other).value);
        }
        else return other.div(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
