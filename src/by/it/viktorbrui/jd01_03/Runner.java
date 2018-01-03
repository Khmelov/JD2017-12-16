package by.it.viktorbrui.jd01_03;

public class Runner {
    public static void main(String[] args){
        String line="1 2 3 4 5 6 7.7 -1";
        double[]dmas=InOut.getArray(line);
        InOut.printArray(dmas);
        System.out.println("Массив D:");
        InOut.printArray(dmas,"D",3);
        System.out.println("Минимум массива D: "+Helper.findMin(dmas));
        System.out.println("Максимум массива D: "+Helper.findMax(dmas));
        Helper.sort(dmas);
        System.out.println("Массив D отсортированный по возрастанию:");
        InOut.printArray(dmas,"D",3);
        System.out.println("Массив полученный в результате умножения матрицы на вектор:");
        double[][]matrix={{1,2,3},{4,5,6}};
        double[]vector={7,8,9};
        double[]mas=Helper.mul(matrix,vector);
        InOut.printArray(mas,"m",5);
        System.out.println("Матрица полученная в результате умножения матрицы на матрицу:");
        double[][]matrixLeft={{1,2,3},{4,5,6}};
        double[][]matrixRight={{7,8},{9,10},{11,12}};
        double[][]matrix1=Helper.mul(matrixLeft,matrixRight);
        Helper.arrayPrint2D(matrix1,"m1");
    }
}
