package by.it.akhmelev.jd01_03;

public class Runner {

    public static void main(String[] args) {
        String line="1 2 3 4 5 7.7 -1";
        double[] dmas=InOut.getArray(line);
        InOut.printArray(dmas);
        InOut.printArray(dmas,"D",3);
    }

}
