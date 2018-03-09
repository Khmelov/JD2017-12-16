package by.it.sevashko.jd01_04;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();

        System.out.println();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
//        String line = "1 2 56 47 232 16 14 -98 12 15 36";
        buildOneDimArray(line);
    }

    static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-2d ",i, j, i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line){
        double[] mas = InOut.getArray(line);
        double first = mas[0];
        double last = mas[mas.length - 1];
        InOut.printArray(mas, "V", 5);
        Helper.sort(mas);
        System.out.println();
        InOut.printArray(mas, "V", 4);
        System.out.println();
        int indexFirst = 0;
        int indexLast = 0;
        for (int i = 0; i < mas.length; i++) {
            if (first == mas[i]) indexFirst = i;
            else if (last == mas[i]) indexLast = i;
        }
        System.out.printf("Index of first element=%d\n", indexFirst);
        System.out.printf("Index of last element=%d\n", indexLast);
        System.out.println();
    }
}
