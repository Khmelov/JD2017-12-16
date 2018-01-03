package by.it.patsko.jd01_03;

/**
 * @author Patsko Arkadzi
 */
public class InOut {
    /**
     * Создание массива double из строки
     *
     * @param line - строка для преобразования
     * @return одномерный массив double
     */
    static double[] getArray(String line) {
        line = line.trim();
        String[] masStr = line.split(" ");
        double[] masdbl = new double[masStr.length];
        for (int i = 0; i < masdbl.length; i++) {
            masdbl[i] = Double.parseDouble(masStr[i]);
        }
        return masdbl;
    }

    /**
     * Вывод массива double в консоль
     *
     * @param arr - одномерный массив
     */
    static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    /**
     * Вывод массива double в консоль по столбцам
     *
     * @param arr         - одномерный массив
     * @param name        - имя массива для вывода
     * @param columnCount - количество колонок
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%- 3d]=%-10.4f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1) System.out.println();
        }
    }
}
