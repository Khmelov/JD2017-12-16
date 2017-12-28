package by.it.sendetskaya.jd01_02;


import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        System.out.println("Введите число n для вывода матрицы: ");
        Scanner sc2=new Scanner (System.in);
        int n=sc2.nextInt();
        int [][] mas1=step1(n);

        int sum=step2(mas1);

        int [][] mas2=step3(mas1);
    }

    //вывести матрицу с генерацией [-n;n]
    static int[][] step1(int n) {
        int r;
        boolean flag;
        int mas[][] = new int[n][n];
        System.out.println("Матрица NxN: ");

        do {
            flag = true;
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas.length; j++) {
                    //if (r!=n && r!=-n)
                    r = (int) (Math.random() * (2 * n + 1)) - n;
                    mas[i][j] = r;

                    System.out.printf("%4d", mas[i][j]);
                    if (mas[i][j] == n || mas[i][j] == -n) flag = false;
                }
                System.out.println();
            }

        } while (flag);
        return mas;
    }

    //найти сумму элементов расположенными между 1 и 2 полож элем кажд строки
    static int step2(int[][] mas) {
        int sum = 0, sum1 = 0;
        int pos1 = -999, pos2 = 0;

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (pos1 == -999) {
                    if (mas[i][j] > 0) {
                        pos1 = j;
                    }
                } else {
                    if (mas[i][j] > 0) {
                        pos2 = j;
                    }
                }
                if (pos1 != -999 && pos2 != 0) {
                    for (j = pos1 + 1; j < pos2; j++) {

                        sum1 += mas[i][j];
                    }
                    pos1 = -999;
                    pos2 = 0;
                    break;
                }
            }
            sum += sum1;
            sum1 = 0;
        }
        System.out.println("Сумма между первым и вторым положительными элементами каждой строки: " + sum);

        return sum;
    }

    //Найти макс элемент в матрице и удалить строку и столбец
    static int[][] step3(int[][] mas) {
        int max = Integer.MIN_VALUE;
        int maxElI = 0, maxElJ = 0;
        int count=0, countRow=0, countCol=0;

        for (int i = 0; i < mas.length; i++)
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > max) {
                    max = mas[i][j];
                }
            }

        for (int i = 0; i < mas.length; i++)
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] == max) {
                    maxElI = i;
                    countRow++;
                    maxElJ = j;
                    countCol++;

//                    for (int k = 0; k < mas.length; k++) {
//                        if (k!=i)
//                            countRow--;
//                        if(k!=j)
//                            countCol--;
//                    }

                }
            }

        int[] countI = new int[countRow];
        int[] countJ = new int[countCol];
        int k=0;
        boolean flag=true;

        for (int i = 0; i < mas.length; i++)
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    maxElI=i;
                    maxElJ=j;
                    if (flag) {
                        countI[k] = +maxElI;
                        //countRow++;

                        countJ[k] = +maxElJ;
                       // countCol++;
                        k++;
                        flag = false;
                    }
                    else {
                        if (countI[k] != maxElI) {
                            countI[k] = +maxElI;
                           // countRow++;
                        }
                        if (countJ[k] != maxElJ) {
                            countJ[k] = +maxElJ;
                           // countCol++;
                        }
                        k++;

//                    for (k = 0; k <=count; k++) {
//                        if (k == 0) {
//                            countI[k] = +maxElI;
//                            countJ[k] = +maxElJ;
//                        } else {
//                            if (maxElI != countI[k]) {
//                                countI[k] = +maxElI;
//                            }
//                            if (maxElJ != countJ[k]) {
//                                countJ[k] = +maxElJ;
//                            }
//                        }
//                    } k++;count++;
                    }
                }
            }

        System.out.println("Максимальный элемент: " + max + " строка " + maxElI
                + " столбец " + maxElJ);

        System.out.println("Новая матрица: ");
        int [][]mas1 = delMatrix(mas, countI, countJ);
        System.out.printf("%4d", mas1);

        return mas1;
    }

    static int[][] delMatrix(int[][] mas, int[] row, int[] col) {
        int newI = 0;
        int n=mas.length - row.length;
        int m=mas.length - col.length;
        int mas1[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
                int newJ = 0;
                for (int j = 0; j < m; j++) {
                    if (row[newI] != i && j != col[newJ]) {
                        mas1[newI][newJ] = mas[i][j];
                        ++newJ;
                    }
                }
                ++newI;
            }
        return mas1;
    }
}