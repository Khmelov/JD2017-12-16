package by.it.karpeichyk.jd01_03;

/**
 * Created by user on 26.12.2017.
 */
public class Runner {
    public static void main(String[] args) {
        double [] v= InOut.getArray("1 2 5 3.3 4 5.4 46.7 5 8 9");
        InOut.printArray(v);
        InOut.printArray(v,"massive",5);
       Helper.findMin(v);
        Helper.findMax(v);
      Helper.sort(v);
    }
}
