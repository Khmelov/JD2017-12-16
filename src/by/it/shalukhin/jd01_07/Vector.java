package by.it.shalukhin.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends AbstractVar {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    Vector (Vector vector){
        this(vector.value);
    }

    Vector (String text){
        value = new double[]{};
        String str = new String(text);
        Pattern pat = Pattern.compile("-?\\d+\\.\\d+[e|E|е|Е]-?\\d+|-?\\d+\\.\\d+|-?\\d+");
        Matcher mat = pat.matcher(str);
        while (mat.find()){
            value = Arrays.copyOf(value, value.length+1);
            value[value.length-1] = Double.parseDouble(mat.group());
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        for (int i = 0; i < value.length; i++) {
            if (i>0) result.append(", ");
            result.append(value[i]);
        }
        result.append("}");
        return result.toString();
    }
}
