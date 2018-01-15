package by.it.kozlov.calc;

class Vector extends Var {

    double[] value;

    @Override
    public Var add(Var other) {
        double[] add = new double[value.length];
        if (other instanceof Scalar) {
            for (int i = 0; i < value.length; i++) {
                add[i] = value[i] + ((Scalar) other).value;
            }
            return new Vector(add);
        }
        if (other instanceof Vector) {
            for (int i = 0; i < value.length; i++) {
                add[i] = value[i] + ((Vector) other).value[i];
            }
            return new Vector(add);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        double[] sub = new double[value.length];
        if (other instanceof Scalar) {
            for (int i = 0; i < value.length; i++) {
                sub[i] = value[i] - ((Scalar) other).value;
            }
            return new Vector(sub);
        }
        if (other instanceof Vector) {
            for (int i = 0; i < value.length; i++) {
                sub[i] = value[i] - ((Vector) other).value[i];
            }
            return new Vector(sub);
        } else
            return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        double[] mul = new double[value.length];
        if (other instanceof Scalar) {
            for (int i = 0;
                 i < value.length; i++) {
                mul[i] = value[i] * ((Scalar) other).value;
            }
            return new Vector(mul);
        }
        if (other instanceof Vector) {
            for (int i = 0; i < value.length; i++) {
                mul[i] = value[i] * ((Vector) other).value[i];
            }
            return new Vector(mul);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        double[] div = new double[value.length];
        if (other instanceof Scalar) {
            for (int i = 0; i < value.length; i++) {
                div[i] = value[i] / ((Scalar) other).value;
            }
            return new Vector(div);
        }
        if (other instanceof Vector) {
            for (int i = 0; i < value.length; i++) {
                div[i] = value[i] / ((Vector) other).value[i];
            }
            return new Vector(div);
        } else
            return other.div(this);
    }

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String strVector) {
        strVector = strVector.replace('{', ' ').replace('}', ' ').trim();
        String[] el = strVector.split(",");
        value = new double[el.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(el[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('{');
        for (int i = 0; i < value.length; i++) {
            if (i > 0) result.append(", ");
            result.append(value[i]);
        }
        result.append('}');
        return result.toString();
    }
}
