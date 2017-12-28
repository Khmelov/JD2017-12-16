package by.it.krasutski.jd01_03;

public class InOut {
    /**
     *
     * @param line исходный строка
     * @return возвращает массив
     */
    static double[] getArray(String line){
        String[] strMas=line.split(" ");
        double[] res=new double[strMas.length];
        for (int i = 0; i < strMas.length; i++) {
            res[i]=Double.parseDouble(strMas[i]);
        }
        System.out.println();
        return res;
    }

    /**
     *
     * @param arr входной массив
     */
    static void printArray(double[ ] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    /**
     *
     * @param arr входной массив
     * @param name имя на экране
     * @param columnCount число столбцов для вывода
     */
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.5f",name,i,arr[i]);
            if ((0==(i+1)%columnCount) || (arr.length-1==i)){
                System.out.println();
                System.out.println();
            }
        }
    }

}
