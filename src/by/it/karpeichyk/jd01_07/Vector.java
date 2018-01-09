package by.it.karpeichyk.jd01_07;

import java.util.Arrays;

/**
 * Created by user on 04.01.2018.
 */
public class Vector extends AbstractVar {
    private double value[];
     public Vector (double[]value){
         this.value = new double[value.length];
         System.arraycopy(value,0,this.value,0,value.length);
     }
     public Vector (Vector vector2){
         this.value=vector2.value;
     }
    Vector (String stringVector)
    {
        stringVector=stringVector.replaceAll("[,;}{]"," ");
        stringVector=stringVector.trim();
        String [] stringVect=stringVector.split(" ");
        double[] value= new double[stringVect.length];
        for (int i = 0; i < stringVect.length; i++) {
            value[i]=Double.parseDouble(stringVect[i]);
        }
        this.value= new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }
    @Override

     public String toString(){
         StringBuilder result = new StringBuilder();
         result.append('{');
         for (int i = 0; i <value.length ; i++) {
             if(i>0)result.append(", ");
             result.append(value[i]);
         }
         result.append('}');
         return result.toString();
     }
}
