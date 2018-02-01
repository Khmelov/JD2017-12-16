package by.it.akhmelev.calc.calc_v3;


class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector){
        this(vector.value);
    }

    Vector(String strVector){
        strVector=strVector.replace('{',' ').replace('}',' ').trim();
        String[] el=strVector.split(",");
        value=new double[el.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(el[i]);
        }
    }



    @Override
    public String toString() {
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
