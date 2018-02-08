package by.it.akhmelev.jd02_06.classwork;

public class ClientA {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            SingleLogger.getInstance().log("test" + i);

        }
    }
}
