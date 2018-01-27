package by.it.akhmelev.jd02_02.classwork2;

public class Cashier implements Runnable {

    private int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (!Dispatcher.allBuyerComplete()) {
            Buyer b = Dispatcher.extractFromQueue();
            if (b != null) {
                System.out.println(this + "Начало обслуживания " + b);
                Helper.sleep(200, 500);
                System.out.println(this + "Конец обслуживания " + b);
                synchronized (b) {
                    b.notify();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Cashier" + number + " ";
    }
}
