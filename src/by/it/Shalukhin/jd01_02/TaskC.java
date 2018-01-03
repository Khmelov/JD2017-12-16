package by.it.Shalukhin.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mas[][] = step1(n);

        int sum = step2(mas);

        int mas_cut[][] = step3(mas);

        /*int[][] v = step3_by_prepod(step1(5));
        for (int[] ints : v) {
            System.out.println(Arrays.toString(ints));
        }*/
    }

    public static int[][] step1(int n) {
        Random rnd = new Random();      //создаём объект рандом
        int[][] arr = new int[n][n];
        do {                                //заполняем массив случайными числами
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = -n + rnd.nextInt(n + 1 - (-n));     //из диапазона -n до n
                }
            }
        } while (!is_n(arr, n));                //проверка есть ли -n или n

        for (int[] ints : arr) {                //печатаем полученный массив
            for (int anInt : ints) {
                System.out.printf("%3d ", anInt);
            }
            System.out.println();
        }
        return arr;         //возвращаем полученный массив
    }

    public static boolean is_n(int[][] arr_for_analise, int n) {            //метод проверка есть ли n или -n
        for (int[] ints : arr_for_analise) {
            for (int anInt : ints) {
                if ((anInt == n) || (anInt == -n)) return true;
            }
        }
        return false;
    }

    public static int step2(int[][] mas) {
        int sum = 0;                                //интересующая сумма
        for (int[] ma : mas) {                      //проход по строкам
            boolean b1 = false;                     //разрешение на участие в сложении
            int mark = 0;                           //маркер индекса первого а потом последнего положительного элемента строки
            int count = 0;                          //счётчик до 2 : встреча первого, затем второго полож. элемента
            int sum_line = 0;                       //сумма интересующих элементов в строке
            for (int i = 0; i < ma.length; i++) {      //проход по строке
                if (ma[i] > 0) {                       //если элемент массива положит-ый:
                    count++;                        //увеличиваем счётчик на единицу
                    b1 = !b1;                         //устанавливаем разрешение на сложение либо снимаем его
                    mark = i;                       //маркируем индекс положительного элемента
                }
                if (count == 2)
                    break;                                    //если счётчик стал равен 2 - значит второй положит-ый элем. пройден и данная строка массива больше не интересует
                if (b1 && (mark != i))
                    sum_line = sum_line + ma[i];     // если установлено разрешение на сложение и текущий элемент не совпадает с маркированным положительным элементом - суммируем
            }
            if (count == 2)
                sum = sum + sum_line;               //полученная сумма строки прибавляется к резульющей сумме в том случае, если в строке был и 1-ый и 2-ой положит.элементы
        }
        System.out.println(sum);
        return sum;                                 //возвращаем интересующую сумму
    }

    public static int[][] step3(int[][] mas) {

        int[][] mas_copy = new int[mas.length][mas[0].length];
        for (int i = 0; i < mas.length; i++) {                   //делаем копию входящего массива чтобы не испортить входящий
            for (int j = 0; j < mas[0].length; j++) {
                mas_copy[i][j] = mas[i][j];
            }
        }

        int max = Integer.MIN_VALUE;

        for (int[] re : mas_copy) {              //ищем максимальный элемент массива
            for (int i : re) {
                if (i > max) max = i;
            }
        }

        int[][] crds = get_coordinates(mas_copy, max);       //получаем координаты всех максимумов в матрице

        int[] strok_del = get_stroki(crds);        //получаем номера всех удаляемых строк по возрастанию

        int[] stolb_del = get_stolb(crds);         //получаем номера всех удаляемых столбцов по возрастанию

        int coun = 0;
        while (coun < strok_del.length) {              //удаляем строки путём переприсваивания значений из нижней строки
            for (int i = 0; i < mas_copy.length - 1; i++) {
                for (int j = 0; j < mas_copy[0].length; j++) {
                    if (i >= strok_del[coun] - coun) mas_copy[i][j] = mas_copy[i + 1][j];
                }
            }
            coun++;
        }

        coun = 0;
        while (coun < stolb_del.length) {          ////удаляем столбцы путём переприсваивания значений из столбца левее
            for (int i = 0; i < mas_copy.length; i++) {
                for (int j = 0; j < mas_copy[0].length - 1; j++) {
                    if (j >= stolb_del[coun] - coun) mas_copy[i][j] = mas_copy[i][j + 1];
                }
            }
            coun++;
        }

        int[][] mas_rezult = new int[mas_copy.length - strok_del.length][mas_copy[0].length - stolb_del.length]; //создаём новый массив: размер за вычетом удаляемых строк и столбцов
        for (int i = 0; i < mas_rezult.length; i++) {               //заполняем массив оставшимися нужными элементами
            for (int j = 0; j < mas_rezult[0].length; j++) {
                mas_rezult[i][j] = mas_copy[i][j];
            }
        }

        for (int[] ints : mas_rezult) {            //печатаем массив
            for (int anInt : ints) {
                System.out.printf("%3d ", anInt);
            }
            System.out.println();
        }

        return mas_rezult;     //возвращаем массив
    }

    public static int[][] get_coordinates(int[][] mas, int el) {        //метод возвращающий координаты всех вхождений интересующего элемента
        int el_numb = 0;

        for (int[] re : mas) {          //считаем сколько заданных элементов в массиве
            for (int i : re) {
                if (i == el) el_numb++;
            }
        }

        int[][] crds = new int[el_numb][2];    //создаём массив для хранения координат заданных элементов

        int coun = 0;

        for (int i = 0; i < mas.length; i++) {           //заполняем массив координатами заданных элементов
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] == el) {
                    crds[coun][0] = i;
                    crds[coun][1] = j;
                    coun++;
                }
            }
        }

        return crds;        //возвращаем массив с координатами
    }

    public static int[] get_stroki(int[][] mas) {           //метод возвращает массив номеров строк в порядке возростания из переданного массива координат
        int[] a = new int[mas.length];      //массив всего перечня строк
        for (int i = 0; i < mas.length; i++) {        //выделяем из входящего массива координаты строк
            a[i] = mas[i][0];
        }

        Arrays.sort(a);         //сортируем массив координат строк по возрастанию

        int n = 1;
        for (int i = 1; i < a.length; i++) {        //переносим уникальные координаты в начало массива
            if (a[i - 1] != a[i]) {
                a[n] = a[i];
                n++;
            }
        }

        int[] stroki = new int[n];      // массив для набора уникальных координат
        for (int i = 0; i < stroki.length; i++) {       //заполняем массив уникальными координатами
            stroki[i] = a[i];
        }
        return stroki;      //возвращаем массив
    }

    public static int[] get_stolb(int[][] mas) {        ////метод возвращает массив номеров столбцов в порядке возростания из переданного массива координат
        int[] b = new int[mas.length];      //массив всего перечня столбцов
        for (int i = 0; i < mas.length; i++) {        //выделяем из входящего массива координаты столбцов
            b[i] = mas[i][1];
        }

        Arrays.sort(b);             //сортируем массив координат столбцов по возрастанию

        int n = 1;
        for (int i = 1; i < b.length; i++) {    ////переносим уникальные координаты в начало массива
            if (b[i - 1] != b[i]) {
                b[n] = b[i];
                n++;
            }
        }

        int[] stolbci = new int[n]; // массив для набора уникальных координат
        for (int i = 0; i < stolbci.length; i++) {       //заполняем массив уникальными координатами
            stolbci[i] = b[i];
        }
        return stolbci;     //возвращаем массив
    }

    static int[][] step3_by_prepod (int[][] mas){

        int max = Integer.MIN_VALUE;

        for (int[] re : mas) {              //ищем максимальный элемент массива
            for (int i : re) {
                if (i > max) max = i;
            }
        }

        int stroki[] = new int[0];      //массив удаляемых строк
        int stolb[] = new int[0];       //массив удаляемых столбцов

        for (int i = 0; i < mas.length; i++) {              //заполняем эти массивы
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max){
                    if (!is_el(stroki,i)) {
                        int[] buf = new int[stroki.length+1];
                        for (int k = 0; k < stroki.length; k++) {
                            buf[k]=stroki[k];
                        }
                        buf[buf.length-1] = i;
                        stroki = buf;
                    }
                    if (!is_el(stolb, j)){
                        int[] buf = new int[stolb.length+1];
                        for (int k = 0; k < stolb.length; k++) {
                            buf[k]=stolb[k];
                        }
                        buf[buf.length-1] = j;
                        stolb = buf;
                    }
                }
            }
        }

        int[][] mas_result = new int[mas.length-stroki.length][mas[0].length-stolb.length];     //результирующий массив
        int n = 0;
        for (int i = 0; i < mas.length; i++) {
            if (is_el(stroki,i)) continue;
            int m = 0;
            for (int j = 0; j < mas[i].length; j++) {
                if (!is_el(stolb, j))mas_result[n][m++] = mas[i][j];
            }
            n++;
        }
        return mas_result;
    }

    static boolean is_el (int[] mas, int el){       //проверка наличия элемента в массиве
        for (int ma : mas) {
            if (ma == el) return true;
        }
        return false;
    }
}
