package by.it.korobeinikov.jd01_10;

@Param(b=9)
public class Bean {

    @Param(b=9)
    static double sum(int a, int b){
        return a+b;
    };

    @Param(a=3,b=4)
    double max(int a, int b){
        return Math.max(a,b);
    };

    double min(int a, int b){
        return Math.min(a,b);
    };

    @Param(a=3,b=4)
    static double avg(int a, int b){
        return (a+b)/2.0;
    };


}
