package by.it.patsko.jd02_01;

public class MyStopwatch extends Thread {
    private static int currentSecond;

    public static int getCurrentSecond() {
        return currentSecond;
    }

    @Override
    public void run() {
        for (int minutes = 0; minutes < 2; minutes++) {
            for (int second = 0; second < 60; second++) {
                try {
                    currentSecond = second;
                    System.out.printf("\n%2d cекунд - количество покупателей: %2d", currentSecond, Runner.queue.size());
                    System.out.print("|");
                    for (int i = 0; i < Runner.queue.size(); i++) {
                        System.out.print("-");
                    }
//                    System.out.println();
                    Thread.sleep(105);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
