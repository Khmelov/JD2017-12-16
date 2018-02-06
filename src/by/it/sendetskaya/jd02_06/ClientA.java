package by.it.sendetskaya.jd02_06;

public class ClientA {
    public static void main(String[] args) {
        SingleLogger singleLogger=SingleLogger.getInstance();
        singleLogger.log("test");
    }
}
