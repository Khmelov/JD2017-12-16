package by.it.vshelukhin.jd02_06;

public class Runner {

    public static void main(String[] args) {
        Singleton log = Singleton.getLoger();
        for (int i = 0; i < 15; i++) {
            try {
                throw new Exception("Ашшшипппка!");
            } catch (Exception e) {
                log.writeLog(e.getMessage());
            }
        }
        log.writeLog("Всё, приехали!");
    }
}
