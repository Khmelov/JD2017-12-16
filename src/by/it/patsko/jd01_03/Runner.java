package by.it.patsko.jd01_03;

import java.util.Arrays;

/**
 * @author Patsko Arkadzi
 */
public class Runner {
    /**
     * Метод main
     *
     * @param args - одномерный массив строк
     */
    public static void main(String[] args) {
        String line = "         71.2 12.3 14.5 789.0 6.7 565.6 76.7 712.3 ";
        double[] mas = InOut.getArray(line);
        InOut.printArray(mas);
        InOut.printArray(mas, "D", 4);
        System.out.println("min=" + Helper.findMin(mas) + "\nmax=" + Helper.findMax(mas));
        Helper.sort(mas);
        InOut.printArray(mas);

        double[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        double[][] matrix2 = {{7, 8}, {9, 10}, {11, 12}};
        double[] vector = {7, 8, 9};
        double[][] matrix3 = Helper.mul(matrix1, matrix2);
        System.out.println(Arrays.toString(Helper.mul(matrix1, vector)));
        System.out.println();
        for (double[] i : matrix3) {
            System.out.println(Arrays.toString(i));
        }
    }
}
