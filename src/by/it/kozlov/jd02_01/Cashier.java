package by.it.kozlov.jd02_01;

public class Cashier implements Runnable {
    private int number;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + "открыл кассу");
        while (!Dispetcher.allBuyerComplete()) {
            Buyer b = Dispetcher.extractFromQueue();
            if (b != null) {
                System.out.println(this + "Начало обслуживания " + b);
                Helper.sleep(200, 500);
                System.out.println(this + "печатаем чек для " + b);
                System.out.println(this + "Конец обслуживания " + b);
                synchronized (b) {
                    b.notify();
                }
            } else
                Thread.yield();
        }
        System.out.println(this + "закрыл кассу.");
    }

    @Override
    public String toString() {
        return "Cashier: Кассир №" + number + " ";
    }
}
