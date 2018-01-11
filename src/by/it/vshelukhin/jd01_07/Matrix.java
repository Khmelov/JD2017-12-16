package by.it.vshelukhin.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends AbstractVar {
    private double[][] value;

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
