package by.it.vshelukhin.jd01_10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Param(a=1,b=2)
public class Bean {

    @Param(a=2,b=5)
    public static double sum (int a, int b) {
        return a+b;
    }

    public double max (int a, int b) {
        return Integer.max(a, b);
    }

    @Param(a=2,b=5)
    public double min (int a, int b) {
        return Integer.min(a,b);
    }

    @Param(a=2,b=5)
    public static double avg (int a, int b) {
        return (a+b)/2.0;
    }
}
