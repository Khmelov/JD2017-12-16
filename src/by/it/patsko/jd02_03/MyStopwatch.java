package by.it.patsko.jd02_03;

public class MyStopwatch extends Thread {
    private static int currentSecond;

    public static int getCurrentSecond() {
        return currentSecond;
    }

    @Override
    public void run() {
        for (int minutes = 0; minutes < 2; minutes++) {
            for (int second = 0; second < 60; second++) {
                int numOfCustomers= Queue.getNumOfAllCustomers()- Queue.getNumOfServedCustomers();//в магазине
//                int numOfCustomers=Queue.getQueueSize();//в очереди

                try {
                    currentSecond = second;
                    System.out.printf("\n%2d cекунд - количество покупателей: %2d", currentSecond, numOfCustomers);
                    System.out.print("|");
                    for (int i = 0; i <numOfCustomers ; i++) {
                        System.out.print("-");
                    }
                    Thread.sleep(105);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
