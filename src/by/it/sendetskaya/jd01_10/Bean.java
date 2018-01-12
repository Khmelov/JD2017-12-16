package by.it.sendetskaya.jd01_10;

public class Bean {

    @Param(a=3,b=4)
    double sum(int a, int b)
    {
        return a+b;
    }

    @Param(a=5,b=2)
    static double max(int a, int b)
    {
        return Math.max(a,b);
    }

    double min(int a, int b)
    {
        return Math.min(a,b);
    }

    @Param(a=6,b=1)
    static double avg(int a, int b)
    {
        return (a+b)/2.0;
    }
}
