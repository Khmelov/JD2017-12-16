package by.it.ikiselev.jd01_09;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector){
        this(vector.value);
    }

    Vector(String strVector){
        strVector=strVector.replace('{',' ').replace('}',' ').trim();
        String[] el=strVector.split(",");
        value=new double[el.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(el[i]);
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
    @Override
    public Var add(Var other) {
        if (other instanceof Vector){
            Vector res = new Vector(this);
            for (int i = 0; i < res.value.length; i++) {
                res.value[i] = res.value[i] + ((Vector) other).value[i];
            }
            return res;
        }
        if (other instanceof Scalar){
            Vector res = new Vector(this);
            for (int i = 0; i < res.value.length; i++) {
                res.value[i] = res.value[i] + ((Scalar) other).getValue();
            }
            return res;
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector){
            Vector res = new Vector(this);
            for (int i = 0; i < res.value.length; i++) {
                res.value[i] = res.value[i] - ((Vector) other).value[i];
            }
            return res;
        }
        if (other instanceof Scalar){
            Vector res = new Vector(this);
            for (int i = 0; i < res.value.length; i++) {
                res.value[i] = res.value[i] - ((Scalar) other).getValue();
            }
            return res;
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector){
            Vector res = new Vector(this);
            for (int i = 0; i < res.value.length; i++) {
                res.value[i] = res.value[i] * ((Vector) other).value[i];
            }
            return res;
        }
        if (other instanceof Scalar){
            Vector res = new Vector(this);
            for (int i = 0; i < res.value.length; i++) {
                res.value[i] = res.value[i] * ((Scalar) other).getValue();
            }
            return res;
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            Vector res = new Vector(this);
            for (int i = 0; i < res.value.length; i++) {
                res.value[i] = res.value[i] / ((Scalar) other).getValue();
            }
            return res;
        }
        return super.div(other);
    }

    public double[] getValue() {
        return value;
    }
}