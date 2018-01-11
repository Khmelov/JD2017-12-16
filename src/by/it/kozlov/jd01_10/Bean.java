package by.it.kozlov.jd01_10;

public class Bean {
    @Param(a = 3, b = 4)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 3, b = 4)
    static double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 3, b = 4)
    double min(int a, int b) {
        return Math.min(a, b);
    }

    @Param(a = 3, b = 4)
    double avg(int a, int b) {
        return a + b;
    }
}
