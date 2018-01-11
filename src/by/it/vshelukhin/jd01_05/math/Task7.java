package by.it.vshelukhin.jd01_05.math;

import java.util.Arrays;
import java.util.Random;

public class Task7 {

    static char left_up_corner = 0x2554;
    static char right_up_corner = 0x2557;
    static char left_down_corner = 0x255A;
    static char right_down_corner = 0x255D;
    static char vertical_line = 0x2551;
    static char horizont_line = 0x2550;
    static char vertical_left_break = 0x2560;
    static char vertical_right_break = 0x2563;
    static char horizont_up_break = 0x2566;
    static char horizont_down_break = 0x2569;
    static char center = 0x256C;

    public static void main(String[] args) {

        int[] masA = bildMassivA(31);

        int numb_stolb = 5;

        printA(masA, numb_stolb);

        int[] masB = bildMassivB(masA);

        numb_stolb = 2;

        printB(masB, numb_stolb);

    }

    static int[] bildMassivA (int countElement){
        Random rnd = new Random();
        int[] result = new int[countElement];
        for (int i = 0; i < result.length; i++) {
            result[i] = rnd.nextInt(348)+103;
        }
        return result;
    }

    static int[] bildMassivB (int[] mas){
        int[] result = {};
        for (int i = 0; i < mas.length; i++) {
            if (mas[i]*0.1 > i){
                result = Arrays.copyOf(result, result.length+1);
                result[result.length-1] = mas[i];
            }
        }
        Arrays.sort(result);
        return result;
    }

    static void printA (int[] masA, int numb_stolb){
        System.out.println(roof(numb_stolb));

        for (int i = 0; i < masA.length; i++) {
            System.out.printf("%s A[%2d]=%3d ",vertical_line, i+1, masA[i]);
            if ((i+1)%numb_stolb == 0 && i != masA.length-1) System.out.print(vertical_line+"\n"+floor(numb_stolb)+"\n");
        }

        int numb_empty_cells = masA.length%numb_stolb != 0 ? numb_stolb-masA.length%numb_stolb : 0;
        if (numb_empty_cells != 0) System.out.print(emptyCell(numb_empty_cells));

        System.out.print("\n");

        System.out.println(ground(numb_stolb));

        System.out.println();
    }

    static void printB (int[] masB, int numb_stolb){

        int num_strok = masB.length%numb_stolb == 0 ? masB.length/numb_stolb : masB.length/numb_stolb+1;

        System.out.println(roof(numb_stolb));

        for (int i = 0; i < num_strok; i++) {
            for (int j = 0; j < numb_stolb; j++) {
                if (i+j*num_strok < masB.length) {
                    System.out.printf("%s B[%2d]=%3d ",vertical_line, 1+ i + j * num_strok, masB[i + j * num_strok]);
                }
                else System.out.print(emptyCell(1));
            }
            if (i+(numb_stolb-1)*num_strok < masB.length) System.out.print(vertical_line);
            if (i != num_strok-1) System.out.print("\n"+floor(numb_stolb)+"\n");
        }
        System.out.print("\n");

        System.out.println(ground(numb_stolb));
    }

    static String roof (int stolb){
        StringBuilder sb = new StringBuilder();
        sb.append(left_up_corner);
        for (int i = 0; i < stolb; i++) {
            for (int j = 0; j < 11; j++) {
                sb.append(horizont_line);
            }
            if (i != stolb-1) sb.append(horizont_up_break);
        }
        sb.append(right_up_corner);
        return sb.toString();
    }

    static String floor (int stolb){
        StringBuilder sb = new StringBuilder();
        sb.append(vertical_left_break);

        for (int i = 0; i < stolb; i++) {
            for (int j = 0; j < 11; j++) {
                sb.append(horizont_line);
            }
            if (i != stolb-1) sb.append(center);
        }
        sb.append(vertical_right_break);
        return sb.toString();
    }

    static String ground (int stolb){
        StringBuilder sb = new StringBuilder();
        sb.append(left_down_corner);
        for (int i = 0; i < stolb; i++) {
            for (int j = 0; j < 11; j++) {
                sb.append(horizont_line);
            }
            if (i != stolb-1) sb.append(horizont_down_break);
        }
        sb.append(right_down_corner);
        return sb.toString();
    }

    static String emptyCell (int num_empty){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num_empty; i++) {
            sb.append(vertical_line+"           ");
        }
        sb.append(vertical_line);
        return sb.toString();
    }
}
