package by.it.kozlov.jd01_10;

public class Bean {
    @Param(a = 3, b = 4)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 2, b = 8)
    static double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 6, b = 5)
    double min(int a, int b) {
        return Math.min(a, b);
    }

    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
