package by.it.kozlov.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Введите n: ");
        n = (sc.nextInt());
        int[][] mas = new int[n][n];
        mas = step1(n);
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        step2(mas);
        step3(mas);
    }

    static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int k = (int) (Math.random() * (n * 2 + 1)) - n;
                    mas[i][j] = k;
                }
            }
        } while (!compare(mas, n));
        return mas;
    }

    public static boolean compare(int[][] mas, int n) {
        for (int[] ints : mas) {
            for (int j : ints) {
                if ((j == n) || (j == -n)) return true;
            }
        }
        return false;
    }

    static int step2(int[][] mas) {
        int avg = 0;
        for (int i = 0; i < mas.length; i++) {
            int a = 0, b = 0;
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] > 0) {
                    a = j;
                    for (int k = j + 1; k < mas.length; k++) {
                        if (mas[i][k] > 0) {
                            b = k;
                            break;
                        }
                    }
                    break;
                }
            }
            if (b == 0 || a == b) break;
            if (mas[i][a] <= 0) {
            } else {
                for (int j = a + 1; j <= b - 1; j++) {
                    avg = avg + mas[i][j];
                }
            }
        }
        System.out.println(avg);
        return avg;
    }

    static int[][] step3(int[][] mas) {
        boolean pass = false, test = false;
        int a = 0, b = 0, c = 0, d = 0, max = Integer.MIN_VALUE;
        int e = mas.length, f = mas.length;

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > max) {
                    max = mas[i][j];
                    a = i;
                    b = j;
                }
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] == max) {
                    c = i;
                    d = j;
                }
            }
        }
        int[][] masLittleOne = new int[mas.length - 1][mas.length - 1];
        do {
            if (pass == true) {
                if (b == d) {
                    int[][] masLittleTwo = new int[mas.length - 1][mas.length];
                    e = mas.length - 1;
                    masLittleOne = masLittleTwo;
                }
                if (a == c) {
                    int[][] masLittleTwo = new int[mas.length][mas.length - 1];
                    f = mas.length - 1;
                    masLittleOne = masLittleTwo;

                }


                a = c;
                b = d;
                test = true;


            }


            for (int i = 0; i < e; i++) {
                if (i < a) {
                    for (int j = 0; j < f; j++) {
                        if (j < b) {
                            masLittleOne[i][j] = mas[i][j];
                        }
                        if (j > b) {
                            masLittleOne[i][j - 1] = mas[i][j];
                        }
                    }
                }
                if (i > a) {
                    for (int j = 0; j < mas.length; j++) {
                        if (j < b) {
                            masLittleOne[i - 1][j] = mas[i][j];
                        }
                        if (j > b) {
                            masLittleOne[i - 1][j - 1] = mas[i][j];
                        }
                    }
                }

            }
            mas = masLittleOne;
            pass = true;

        } while (test != true);


        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }

        return mas;
    }
}

