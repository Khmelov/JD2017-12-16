package by.it.patsko.jd01_07;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends AbstractVar {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String strVector) {
        Pattern p=Pattern.compile("[0-9]");
        Matcher mchr=p.matcher(strVector);
        ArrayList<Double> list=new ArrayList<>();
        while (mchr.find()){
            list.add(Double.parseDouble(mchr.group()));
        }
        this.value=new double[list.size()];
        for (int i = 0; i < value.length; i++) {
            this.value[i]=list.get(i);
        }
        
        /*String[] str = strVector.trim().split(",");
        value = new double[str.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = Double.parseDouble(str[i]);
        }*/
    }

    @Override
    public String toString() {
//        return Arrays.toString(value).replace('{','[').replace('}',']');
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
