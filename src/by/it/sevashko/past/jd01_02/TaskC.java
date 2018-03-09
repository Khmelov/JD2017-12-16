package by.it.sevashko.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int n = 2;
        int[][] matrix = step1(n);
        System.out.println();
        int sum = step2(matrix);
        System.out.println();
        int[][] newMatrix = step3(matrix);
    }

    static int[][] step1(int n){
        int[][] mas = new int[n][n];
        Random generator = new Random();
        boolean flag1 = false;
        boolean flag2 = false;
        while (!flag1 | !flag2) {
            flag1 = false;
            flag2 = false;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    mas[i][j] = (int) (Math.random()*(n+1));
                    if (generator.nextInt(2) == 1) mas[i][j] = mas[i][j] * -1;
                    if (!flag1 & mas[i][j] == -n) flag1 = true;
                    if (!flag2 & mas[i][j] == n) flag2 = true;
                }
            }
        }
        printMatrix(mas);
        return mas;
    }

    static int step2(int[][] mas){
        int sum = 0;
        for (int i = 0; i < mas.length; i++){
            boolean flag = false;
            for (int j = 1; j < mas.length; j++){
                if (mas[i][j-1] > 0 & !flag) flag = true;
                if (flag & mas[i][j] <= 0) sum = sum + mas[i][j];
                else if (flag & mas[i][j] > 0) break;
            }
        }
        System.out.println(sum);
        return sum;
    }

    static int[][] step3(int[][] mas){
        int max = mas[1][1];
        for (int[] row : mas){
            for (int item : row){
                if (item > max) max = item;
            }
        }
        int[][] helper = new int[mas.length][mas[0].length];
        for (int i = 0; i < mas.length; i++){
            for (int j = 0; j < mas[0].length; j++){
                if (mas[i][j] == max) helper[i][j] = 1;
                else helper[i][j] = 0;
            }
        }
        // deletes rows
        for (int i = helper.length - 1; i >= 0; i--){
            boolean flag = false;
            for (int j = 0; j < helper[0].length; j++){
                if (helper[i][j] == 1){
                    flag = true;
                    break;
                }
            }
            if (flag){
                int[][] newMas = new int[mas.length - 1][mas[0].length];
                for (int m = 0; m < mas.length; m++){
                    for (int n = 0; n < mas[0].length; n++){
                        if(m < i) newMas[m][n] = mas[m][n];
                        if(m > i) newMas[m - 1][n] = mas[m][n];
                    }
                }
                mas = newMas;
            }
        }
        //deletes columns
        for (int j = helper[0].length - 1; j >= 0; j--){
            boolean flag = false;
            for (int i = 0; i < helper.length; i++){
                if (helper[i][j] == 1){
                    flag = true;
                    break;
                }
            }
            if (flag){
                int[][] newMas = new int[mas.length][mas[0].length-1];
                for (int m = 0; m < mas.length; m++){
                    for (int n = 0; n < mas[0].length; n++){
                        if(n < j) newMas[m][n] = mas[m][n];
                        if(n > j) newMas[m][n - 1] = mas[m][n];
                    }
                }
                mas = newMas;
            }
        }
        printMatrix(mas);
        return mas;
    }

    static void printMatrix(int[][] mas){
        //prints array
        for (int i = 0; i < mas.length; i++){
            for (int j = 0; j < mas[i].length; j++){
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
    }
}
