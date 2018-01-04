package by.it.sevashko.jd01_07;

public class Matrix extends AbstractVar {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][];
        for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++){
            this.value[rowNumber] = new double[value[rowNumber].length];
            System.arraycopy(value[rowNumber], 0, this.value[rowNumber], 0, value.length);
        }
    }

    Matrix(Matrix other){
        this.value = new double[other.value.length][];
        for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++){
            this.value[rowNumber] = new double[other.value[rowNumber].length];
            System.arraycopy(other.value[rowNumber], 0, this.value[rowNumber], 0, value.length);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('{');
        for (int rowNumber = 0; rowNumber < value.length; rowNumber++){
            if (rowNumber > 0) result.append(", ");
            result.append('{');
            for (int itemNumber = 0; itemNumber < value[rowNumber].length; itemNumber++){
                if (itemNumber > 0) result.append(", ");
                result.append(value[rowNumber][itemNumber]);
            }
            result.append('}');
        }
        result.append('}');
        return result.toString();
    }
}
