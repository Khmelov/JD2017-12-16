package by.it.patsko.jd01_02;

import java.util.*;

class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] mas = step1(n);
        step2(mas);
        step3(mas);
    }

    static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //Иногда, при определенном наборе сгенерированных цифр,
                // тест может ругаться: "В массиве нет максимума 5 или минимума -5"
                mas[i][j] = (int) ((Math.random() * ((n + 1) + (n + 1))) - (n + 1));
            }
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.println(Arrays.toString(mas[i]));
        }
        return mas;
    }

    static int step2(int[][] mas) {
        int sum = 0;
        boolean f = false;

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (f) {
                    if ((j==mas.length-1&&f)||mas[i][j] > 0){f=!f; break;}
                    sum += mas[i][j];
                }
                if((j==mas.length-1&&f)||mas[i][j] > 0) f=!f;
            }
        }
        System.out.println("sum=" + sum);
        return sum;
    }

    static int[][] step3(int[][] mas) {
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> iDelList=new ArrayList<>();
        ArrayList<Integer> jDelList=new ArrayList<>();

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (max < mas[i][j]) max = mas[i][j];
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] == max){
                    if(!iDelList.contains(i)) iDelList.add(i);
                    if(!jDelList.contains(j)) jDelList.add(j);
                }
            }
        }
//        System.out.println("\niDelList="+iDelList+" jDelList="+jDelList);
        mas = copyMassWithoutElem(iDelList, jDelList, mas);
        for (int i = 0; i < mas.length; i++) {
            System.out.println(Arrays.toString(mas[i]));
        }
        return mas;
    }
    static int[][] copyMassWithoutElem(ArrayList<Integer> iDelList, ArrayList<Integer> jDelList, int[][] mas) {
        int[][] result = new int[mas.length - iDelList.size()][mas.length - jDelList.size()];
        for (int iRez = 0, iMas = 0; iRez < result.length; iRez++, iMas++) {
            if (iDelList.contains(iRez)) iMas++;
            if (iMas == mas.length) break;
            for (int jRez = 0, jMas = 0; jRez < result[iRez].length; jRez++, jMas++) {
                if (jDelList.contains(jRez)) jMas++;
                if (jMas == mas.length) break;
                result[iRez][jRez] = mas[iMas][jMas];
            }
        }
        return result;
    }
}