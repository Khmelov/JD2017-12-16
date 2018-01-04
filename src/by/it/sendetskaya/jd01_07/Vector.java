package by.it.sendetskaya.jd01_07;


public class Vector  extends AbstractVar {

    private double [] value;

   Vector(double[] value) {
        this.value = new  double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    Vector(Vector vector)
    {
        this(vector.value);
    }

    Vector (String strVector)
    {
        strVector=strVector.replaceAll("[,;}{]"," ");
        strVector=strVector.trim();
        String [] strVect=strVector.split(" ");
        double[] value= new double[strVect.length];
        for (int i = 0; i < strVect.length; i++) {
            value[i]=Double.parseDouble(strVect[i]);
        }
        this.value= new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }


    @Override
    public String toString() {
        StringBuilder result=new StringBuilder();
        result.append('{');
        for (int i = 0; i < value.length; i++) {
            if (i>0)
                result.append(", ");
            result.append(value[i]);
        }
        result.append('}');

        return result.toString();
    }
}
