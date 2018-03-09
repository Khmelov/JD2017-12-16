package by.it.sevashko.jd01_05;

public class Task6 {
    static void work(int length) {
        double[] array = new double[length];
        double l = 5.33, r = 9, z;
        double dx = (r - l)/length;
        int i = 0, newLenghth = 0;
        while (l < r){
            array[i] = Math.cbrt(l*l+4.5);
            if (array[i] > 3.5) newLenghth = newLenghth + 1;
            l = l + dx;
            i = i + 1;
        }
        System.out.println("Массив A[]");
        InOut.printArray(array, "A", 5);

        double[] newArray = new double[newLenghth];
        i = 0;
        double geom = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > 3.5) {
                newArray[i] = array[j];
                geom = geom * array[j];
                i = i + 1;
            }
        }
        geom = Math.pow(geom, (double)1/newLenghth);
        System.out.println("Массив B[] из элементов массива A > 3.5");
        InOut.printArray(newArray, "B", 5);
        System.out.printf("Среднее геометрическое значение = %.4f", geom);
    }
}
