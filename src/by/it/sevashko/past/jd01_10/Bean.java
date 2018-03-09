package by.it.sevashko.jd01_10;

public class Bean {

    @Param(a = 5, b = 8)
    static double sum(int a, int b){
        return a + b;
    }

    @Param(a = 6, b = 9)
    static double max(int a, int b){
        if (a > b) return a;
        return b;
    }

    @Param(a = 11, b = 48)
    double min(int a, int b){
        if (a < b) return a;
        return b;
    }

    double avg(int a, int b){
        return ((double)(a + b)) / 2;
    }
}
