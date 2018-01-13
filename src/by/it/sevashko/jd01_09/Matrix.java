package by.it.sevashko.jd01_09;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][];
        for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++){
            this.value[rowNumber] = new double[value[rowNumber].length];
            System.arraycopy(value[rowNumber], 0, this.value[rowNumber], 0, value.length);
        }
    }

    Matrix(Matrix other){
        this(other.value);
    }

    Matrix(String strMatrix){
        Pattern rowPattern = Pattern.compile("[\\[{][0-9\\s.,\\+-]*[]}]");
        Matcher rowMatcher = rowPattern.matcher(strMatrix);
        ArrayList<ArrayList<Double>> rowArray = new ArrayList<>();
        while (rowMatcher.find()){
            Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
            Matcher matcher = pattern.matcher(rowMatcher.group());
            ArrayList<Double> array = new ArrayList<>();
            while (matcher.find()){
                Double item = Double.parseDouble(matcher.group());
                array.add(item);
            }
            rowArray.add(array);
        }
        this.value = new double[rowArray.size()][];
        for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++){
            int rowSize = rowArray.get(rowNumber).size();
            this.value[rowNumber] = new double[rowSize];
            for (int i = 0; i < this.value[rowNumber].length; i++) {
                this.value[rowNumber][i] = rowArray.get(rowNumber).get(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('{');
        for (int rowNumber = 0; rowNumber < value.length; rowNumber++){
            if (rowNumber > 0) result.append(", ");
            result.append('{');
            for (int itemNumber = 0; itemNumber < value[rowNumber].length; itemNumber++){
                if (itemNumber > 0) result.append(", ");
                result.append(value[rowNumber][itemNumber]);
            }
            result.append('}');
        }
        result.append('}');
        return result.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            Matrix res = new Matrix(this);
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res.value[rowNumber][colNumber] = res.value[rowNumber][colNumber] + ((Scalar) other).getValue();
                }
            }
            return  res;
        }
        if (other instanceof Matrix){
            Matrix res = new Matrix(this);
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res.value[rowNumber][colNumber] = res.value[rowNumber][colNumber] + ((Matrix) other).value[rowNumber][colNumber];
                }
            }
            return res;
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            Matrix res = new Matrix(this);
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res.value[rowNumber][colNumber] = res.value[rowNumber][colNumber] - ((Scalar) other).getValue();
                }
            }
            return  res;
        }
        if (other instanceof Matrix){
            Matrix res = new Matrix(this);
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res.value[rowNumber][colNumber] = res.value[rowNumber][colNumber] - ((Matrix) other).value[rowNumber][colNumber];
                }
            }
            return res;
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            Matrix res = new Matrix(this);
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res.value[rowNumber][colNumber] = res.value[rowNumber][colNumber] * ((Scalar) other).getValue();
                }
            }
            return res;
        }
        if (other instanceof Vector){
            double[] res = new double[this.value.length];
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res[rowNumber] = res[rowNumber] + this.value[rowNumber][colNumber] * ((Vector) other).getValue()[colNumber];
                }
            }
            return new Vector(res);
        }
        if (other instanceof Matrix){
            double[][] res = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int m = 0; m < ((Matrix) other).value[0].length; m++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        res[i][m] = res[i][m] + this.value[i][j] * ((Matrix) other).value[j][m];
                    }
                }
            }
            return new Matrix(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            Matrix res = new Matrix(this);
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res.value[rowNumber][colNumber] = res.value[rowNumber][colNumber] / ((Scalar) other).getValue();
                }
            }
            return res;
        }
        return super.div(other);
    }
}
