package by.it.sevashko.calc;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector){
        this(vector.value);
    }

    Vector(String strVector){
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        Matcher matcher = pattern.matcher(strVector);
        ArrayList<Double> array = new ArrayList<>();
        while (matcher.find()){
            Double item = Double.parseDouble(matcher.group());
            array.add(item);
        }
        this.value = new double[array.size()];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = array.get(i);
        }

        // another version
        /*strVector = strVector.substring(1, strVector.length()-1);
        Pattern pattern = Pattern.compile("[ ,]+");
        String[] vectorArray = pattern.split(strVector);
        this.value = new double[vectorArray.length];
        for (int i = 0; i < vectorArray.length; i++) {
            this.value[i] = Double.parseDouble(vectorArray[i]);
        }*/
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
