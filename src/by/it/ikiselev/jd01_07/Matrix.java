package by.it.ikiselev.jd01_07;

public class Matrix extends AbstractVar{

    private double[][] value;
    public Matrix(double[][] value){
        this.value=value;
    }
    public Matrix(Matrix matrix){
        this(matrix.value);
    }
    public Matrix(String matrix){
        String[] res1=matrix.split("},");
        String[] res11=res1[0].split(",");
        double[][] result = new double[res1.length][res11.length];
        for (int i = 0; i <res1.length ; i++) {
            res1[i]=res1[i].replace('{',' ').replace('}',' ').trim();
            String[] res2=res1[i].split(",");
            for (int j = 0; j < res11.length; j++) {
                result[i][j] =Double.parseDouble(res2[j]);
            }
        }
        this.value=result;
    }
    @Override
    public String toString() {
        //return  Arrays.toString(value).replace('[','{').replace(']','}');
        StringBuilder result=new StringBuilder();
        result.append("{{");
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j>0) result.append(", ");
                result.append(value[i][j]);
            }
            if (i!=value.length-1)result.append("}, {");
        }
        result.append("}}");
        return result.toString();
    }

}
