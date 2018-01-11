package by.it.patsko.jd01_09;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) return new Scalar(this.value + ((Scalar) other).value);
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) return new Scalar(this.value - ((Scalar) other).value);
        else {
            Scalar minus = new Scalar(-1);
            return other.sub(this).mul(minus);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) return new Scalar(this.value * ((Scalar) other).value);
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws ArithmeticException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0) throw new ArithmeticException("Division by zero");
            else return new Scalar(this.value / ((Scalar) other).value);
        } else return super.div(other);
    }
}
