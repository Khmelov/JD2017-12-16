package by.it.shalukhin.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this(matrix.value);
    }

    Matrix (String text){
        String[] buf = {};
        Pattern pat = Pattern.compile("\\{[^\\{].*?\\}");
        Matcher mat = pat.matcher(text);
        while (mat.find()){
            buf = Arrays.copyOf(buf, buf.length+1);
            buf[buf.length-1] = mat.group();
        }
        value = new double[buf.length][0];
        pat = Pattern.compile("-?\\d+\\.\\d+[e|E|е|Е]-?\\d+|-?\\d+\\.\\d+|-?\\d+");
        for (int i = 0; i < buf.length; i++) {
            mat = pat.matcher(buf[i]);
            while (mat.find()){
                value[i] = Arrays.copyOf(value[i], value[i].length+1);
                value[i][value[i].length-1] = Double.parseDouble(mat.group());
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[][] temp = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    temp[i][j] = value[i][j] + ((Scalar) other).value;
                }
            }
            return new Matrix(temp);
        }
        if (other instanceof Matrix && value.length == ((Matrix) other).value.length && value[0].length == ((Matrix) other).value[0].length){
            double[][] temp = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    temp[i][j] = value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(temp);
        }
        else{
            System.out.println("Операция не возможна");
            return null;
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[][] temp = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    temp[i][j] = value[i][j] - ((Scalar) other).value;
                }
            }
            return new Matrix(temp);
        }
        if (other instanceof Matrix && value.length == ((Matrix) other).value.length && value[0].length == ((Matrix) other).value[0].length){
            double[][] temp = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    temp[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(temp);
        }
        else{
            System.out.println("Операция не возможна");
            return null;
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[][] temp = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    temp[i][j] = value[i][j] * ((Scalar) other).value;
                }
            }
            return new Matrix(temp);
        }
        if (other instanceof Vector && value[0].length == ((Vector) other).value.length){
            double[] temp = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                double sum = 0;
                for (int j = 0; j < value[i].length; j++) {
                    sum = sum + value[i][j] * ((Vector) other).value[j];
                }
                temp[i] = sum;
            }
            return new Vector(temp);
        }
        if (other instanceof Matrix && value[0].length == ((Matrix) other).value.length){
            double[][] temp = new double[value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    double sum = 0;
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        sum = sum + value[i][k] * ((Matrix) other).value[k][j];
                    }
                    temp[i][j] = sum;
                }
            }
            return new Matrix(temp);
        }
        else {
            System.out.println("Операция не возможна");
            return null;
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[][] temp = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    temp[i][j] = value[i][j] / ((Scalar) other).value;
                }
            }
            return new Matrix(temp);
        }
        else {
            System.out.println("Операция не возможна");
            return null;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {
                if (j != value[i].length-1) sb.append(value[i][j]+", ");
                else sb.append(value[i][j]);
            }
            if (i != value.length-1) sb.append("}, ");
            else sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }

}
