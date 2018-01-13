package by.it.pozdeev.jd01_02;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        step1(n);
//        int[][] mas = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                mas[i][j] = sc.nextInt();
//            }
//        }
//        step2(mas);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                mas[i][j] = sc.nextInt();
//            }
//        }

        step3(new int[][]{{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}});
    }


    static int[][] step1(int n) {
        int mas[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", mas[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        boolean ok = false;
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mas[i][j] == n || mas[i][j] == -n) ok = true;
                    else mas[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                }
            }
        }
        while (!ok);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", mas[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        return mas;
    }

    static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            boolean x1 = false;
            boolean x2 = false;
            int x3 = 0, x4 = 0;
            for (int j = 0; j < mas[i].length - 1; j++) {
                if (mas[i][j] > 0 && !x1) {
                    x1 = true;
                    x3 = j;
                }
                if (mas[i][j + 1] > 0 && x1 && !x2) {
                    x2 = true;
                    x4 = j + 1;
                }

            }
            for (int j = x3 + 1; j < x4; j++) {
                sum = sum + mas[i][j];
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.printf("%3d", mas[i][j]);
            }
            System.out.println();
        }
        System.out.println(sum);
        return sum;
    }

    static int[][] step3(int[][] mas) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > max) max = mas[i][j];
            }
        }
        int k = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] == max) k++;
            }
        }
        int col[] = new int[k];
        int row[] = new int[k];
        int cols[] = new int[mas.length];
        int rows[] = new int[mas.length];
        k = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] == max) {
                    col[k] = i;
                    row[k] = j;
                    k++;
                    cols[i] = 1;
                    rows[j] = 1;
                }
                ;
            }
        }
        Arrays.sort(col);
        Arrays.sort(row);
        int m = 0;
        int l = 0;
        for (int i = 0; i < k - 1; i++) {
            if (col[i] == col[i + 1]) m++;
        }
        m = k - m;
        for (int i = 0; i < k - 1; i++) {
            if (row[i] == row[i + 1]) l++;
        }
        l = k - l;
        for (int i = 0; i < k - 1; i++) {
            if (col[i] == col[i + 1]) m++;
        }
        int[][] mas1 = new int[mas.length - m][mas[0].length - l];
        m = 0;
        l = 0;
        for (int i = 0; i < mas.length; i++) {
            if (cols[i] != 1) {
                for (int j = 0; j < mas[0].length; j++) {
                    if (rows[j] != 1) {
                        mas1[m][l] = mas[i][j];
                        l++;
                    }
                }
                m++;l=0;
            }
        }
        return mas1;
    }
}