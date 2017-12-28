package by.it.ikiselev.jd01_03;

public class Runner {
    public static void main(String[] args) {
        String line="7 8 9 10 13";
        double[] dmas= InOut.getArray(line);
        InOut.printArray(dmas);
        InOut.printArray(dmas,"D",3);

    }
}
