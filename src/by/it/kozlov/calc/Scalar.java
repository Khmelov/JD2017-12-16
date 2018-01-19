package by.it.kozlov.calc;

public class Scalar extends Var {
    public double value;

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value + ((Scalar) other).value);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value - ((Scalar) other).value);
        } else {
            Scalar minus = new Scalar(-1);
            return other.sub(this).mul(minus);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value * ((Scalar) other).value);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){

            double v=((Scalar) other).value;
            if (v==0)
                throw new CalcException(String.format(" Деление на 0 невозможно"));
            return new Scalar(this.value / v);

        }
        else
            return super.div(other);
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar other) {
        this.value = other.value;
    }

    Scalar(String string) {
        this.value = Double.parseDouble(string);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
