package by.it.korobeinikov.jd01_07;

public class Vector  extends AbstractVar {
    private double[] value;
    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector){
        this.value = new double[vector.value.length];
        System.arraycopy(vector.value, 0, this.value, 0, value.length);
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
