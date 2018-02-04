package by.it.karpeichyk.jd02_02;

/**
 * Created by user on 29.01.2018.
 */
public class Cashier implements Runnable {
    private int number;


    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {

        System.out.println(this + "Открыл кассу!");

        while (!Dispatcher.allByerComplete()) {
            Byer b = Dispatcher.extracrToQueue();
            if (b != null) {
                System.out.println(this + "Начало обслуживания " + b);
                Helper.sleep(200, 500);
                System.out.println(this + "Печатаем чек " + b);
                System.out.println(this + "Конец обслуживания " + b);
                synchronized (b) {
                    b.notify();
                }
            } else
                Thread.yield();
        }
        System.out.println(toString() + "закрыл кассу");
    }

    @Override
    public String toString() {
        return "Cashier: Кассир №" + number + " ";
    }
}
