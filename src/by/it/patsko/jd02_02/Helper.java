package by.it.patsko.jd02_02;

import java.util.Random;


class Helper {
    private final static Random random = new Random();

    static int getRandom(int bound) {
        return random.nextInt(bound);
    }

    static int getRandom(int start, int stop) {
        return random.nextInt(stop - start) + 1;
    }

    static void sleep(int start, int stop, boolean isPensioner) {
        try {
            Thread.sleep(isPensioner ? (long) (getRandom(start, stop) * 1.5) : getRandom(start, stop));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void sleep(int start, int stop) {
        try {
            Thread.sleep(getRandom(start, stop));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int getRandomCustomers(int currentSecond) {
        int result=0;
        if (currentSecond< 30) {
            while ( result+(Queue.getNumOfAllCustomers()-Queue.getNumOfServedCustomers())< currentSecond + 10) {//всего в магазине
//            while ( result+Queue.getQueueSize()< currentSecond + 10) {//в очереди
                result += getRandom(3);
            }
        } else {
            while (result+(Queue.getNumOfAllCustomers()-Queue.getNumOfServedCustomers())<= 40 + (30 - currentSecond)){//всего в магазине
//            while (result+Queue.getQueueSize()<= 40 + (30 - currentSecond)){//в очереди
                result += getRandom(3);
            }
        }

        return result;
    }
}
