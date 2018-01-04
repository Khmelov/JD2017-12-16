package by.it.krasutski.jd01_07;

import java.util.Arrays;

public class Vector extends AbstractVar {

    private double[] value;

    public Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    public Vector(Vector vector){
        this(vector.value);
    }



    @Override
    public String toString() {
        StringBuilder result=new StringBuilder();
        result.append('{');
        for (int i = 0; i < value.length; i++) {
            if (i>0) result.append(", ");
            result.append(value[i]);
        }
        result.append('}');
        return result.toString();
    }
}
