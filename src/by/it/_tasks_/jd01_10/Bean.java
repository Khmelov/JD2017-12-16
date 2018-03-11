package by.it._tasks_.jd01_10;

class Bean {

    @Param(a=3,b=40)
    static double sum(int a, int b){
        return a+b;
    }

    @Param(a=3,b=40)
    static double avg(int a, int b){
        return (a+b)/2.0;
    }

    @Param(a=3,b=40)
    double max(int a, int b){
        return Math.max(a,b);
    }

    double min(int a, int b){
        return Math.min(a,b);
    }

}
