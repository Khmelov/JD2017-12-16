package by.it.viktorbrui.jd01_07;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends AbstractVar {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][];
        for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++){
            this.value[rowNumber] = new double[value[rowNumber].length];
            System.arraycopy(value[rowNumber], 0, this.value[rowNumber], 0, value.length);
        }
    }

    Matrix(Matrix other){
        this.value = new double[other.value.length][];
        for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++){
            this.value[rowNumber] = new double[other.value[rowNumber].length];
            System.arraycopy(other.value[rowNumber], 0, this.value[rowNumber], 0, value.length);
        }
    }

    Matrix(String strMatrix){
        Pattern rowPattern = Pattern.compile("[\\[{][0-9\\s.,]*[]}]");
        Matcher rowMatcher = rowPattern.matcher(strMatrix);
        ArrayList<ArrayList<Double>> rowArray = new ArrayList<>();
        while (rowMatcher.find()){
            Pattern pattern = Pattern.compile("[0-9]+\\.?[0-9]*");
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
}
