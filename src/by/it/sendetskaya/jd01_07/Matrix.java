package by.it.sendetskaya.jd01_07;

class Matrix extends AbstractVar {
    private double [][] value;

    Matrix(double[][]value)
    {
        this.value = new  double[value.length][value.length];
        System.arraycopy(value,0,this.value,0,value.length);

    }

    Matrix(Matrix matrix)
    {
        this(matrix.value);
    }

    Matrix(String strMatrix)
    {
        strMatrix=strMatrix.replaceAll("[,;}{]"," ");
        strMatrix=strMatrix.trim();
        String [] strMat=strMatrix.split(" {2}");
        //String[] strMatReady=new String[strMat.length];
        double[][] value= new double[strMat.length][strMat.length];
        for (int i = 0; i < strMat.length; i++) {
            strMat[i]=strMat[i].trim();
            String[] strMatReady= (strMat[i].split(" "));
            for (int j = 0; j < strMatReady.length; j++) {
                value[i][j]=Double.parseDouble(strMatReady[j]);
            }
        }

        this.value= new double[value.length][value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    @Override
    public String toString() {
        StringBuilder result=new StringBuilder();
        result.append('{');
        for (int i = 0; i < value.length; i++){
            result.append('{');
            for (int j = 0; j < value[0].length; j++) {
                if (j > 0)
                    result.append(", ");
                result.append(value[i][j]);
            }
            if(i<value.length-1)
                result.append("}, ");
            else result.append('}');
        }
        result.append('}');

        return result.toString();
    }
}
