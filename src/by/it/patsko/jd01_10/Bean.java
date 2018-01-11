package by.it.patsko.jd01_10;


class Bean {
    @Param(a=3,b=4)
    static double sum(int a, int b){
        return a+b;
    }
    @Param(a=3,b=4)
    double max(int a, int b){
        return a>b?a:b;
    }

    double min(int a, int b){
        return a<b?a:b;
    }
    @Param(a=3,b=4)
    static double avg(int a, int b){
        return (a+b)/2.0;
    }
}
