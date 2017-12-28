package by.it.krasutski.jd01_03;

public class Runner {
    /**
     *
     * @param args аргументы
     */
    public static void main(String[] args) {
        String line="1 2 3 4 5 7.7 -1";
        double[] dmas=InOut.getArray(line);
        InOut.printArray(dmas);
        InOut.printArray(dmas,"D",3);
        Helper.findMax(dmas);
        Helper.findMin(dmas);
        Helper.sort(dmas);
        double[][] ma={
                {1, 2},
                {6, 7}
        };
        double[] ve={1, 2};
        double[][] mb={
                {5, 3},
                {6, 2}
        };
        Helper.mul(ma,ve);
        Helper.mul(ma,mb);
    }
}
