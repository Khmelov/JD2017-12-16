package by.it.ikiselev.jd01_07;

import java.util.Arrays;

public class Vector extends AbstractVar{
    private double[] value;

    public Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    public Vector(Vector vector){
        this(vector.value);
    }
    public Vector (String strVector){
        strVector=strVector.replace('{',' ').replace('}',' ').trim();
        String[] res=strVector.split(",");
        double[] result=new double[res.length];
        for (int i = 0; i < res.length; i++) {
            result[i]=Double.parseDouble(res[i]);
        }
        this.value=result;}


    @Override
    public String toString() {
        //return  Arrays.toString(value).replace('[','{').replace(']','}');
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
