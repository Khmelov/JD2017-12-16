package by.it.shalukhin.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
    double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String text) {
        value = new double[]{};
        String str = new String(text);
        Pattern pat = Pattern.compile("-?\\d+\\.\\d+[e|E|е|Е]-?\\d+|-?\\d+\\.\\d+|-?\\d+");
        Matcher mat = pat.matcher(str);
        while (mat.find()) {
            value = Arrays.copyOf(value, value.length + 1);
            value[value.length - 1] = Double.parseDouble(mat.group());
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] temp = new double[value.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = value[i] + ((Scalar) other).value;
            }
            return new Vector(temp);
        }
        if (other instanceof Vector && value.length == ((Vector) other).value.length) {
            double[] temp = new double[value.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = value[i] + ((Vector) other).value[i];
            }
            return new Vector(temp);
        } else {
            System.out.println("Операция не возможна");
            return null;
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[] temp = new double[value.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = value[i] - ((Scalar) other).value;
            }
            return new Vector(temp);
        }
        if (other instanceof Vector && value.length == ((Vector) other).value.length) {
            double[] temp = new double[value.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = value[i] - ((Vector) other).value[i];
            }
            return new Vector(temp);
        } else {
            System.out.println("Операция не возможна");
            return null;
        }
    }

    @Override
    public Var mul(Var other) {

        if (other instanceof Scalar) {
            double[] temp = new double[value.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = value[i] * ((Scalar) other).value;
            }
            return new Vector(temp);
        }
        if (other instanceof Vector && value.length == ((Vector) other).value.length) {
            double temp = 0;
            for (int i = 0; i < value.length; i++) {
                temp = temp + value[i] * ((Vector) other).value[i];
            }
            return new Scalar(temp);
        }
        if (other instanceof Matrix && value.length == ((Matrix) other).value.length) {
            double[] temp = new double[((Matrix) other).value[0].length];
            for (int i = 0; i < ((Matrix) other).value[0].length; i++) {
                double sum = 0;
                for (int j = 0; j < ((Matrix) other).value.length; j++) {
                    sum = sum + value[j] * ((Matrix) other).value[j][i];
                }
                temp[i] = sum;
            }
            return new Vector(temp);
        } else {
            System.out.println("Операция не возможна");
            return null;
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] temp = new double[value.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = value[i] / ((Scalar) other).value;
            }
            return new Vector(temp);
        } else {
            System.out.println("Операция не возможна");
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        for (int i = 0; i < value.length; i++) {
            if (i > 0) result.append(", ");
            result.append(value[i]);
        }
        result.append("}");
        return result.toString();
    }
}
