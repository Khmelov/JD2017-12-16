package by.it.korobeinikov.jd01_03;

public class Runner {
    public static void main(String[] args) {
        String line="5 4 3 2 1 7.7 -1";
        double[] dmas=InOut.getArray(line);
        InOut.printArray(dmas);
        System.out.println();
        InOut.printArray(dmas, "D",3);
        Helper.findMax(dmas);
        Helper.findMin(dmas);
        Helper.sort(dmas);
    }
}
