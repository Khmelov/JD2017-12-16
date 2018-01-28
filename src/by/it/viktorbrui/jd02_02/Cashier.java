package by.it.viktorbrui.jd02_02;

public class Cashier implements Runnable {

    private int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this+"открыл кассу.");
        while (!Dispatcher.allBuyerComplete()) {
            Buyer b = Dispatcher.extractFromQueue();
            //если есть покупатель, обслуживаем его
            if (b != null) {
                System.out.println(this + "Начало обслуживания " + b);
                Helper.sleep(200, 500);
                System.out.println(this + "печатаем чек для " + b + " сумм: "+Goods.getPrice(Goods.rndGoodName()));
                System.out.println(this + "Конец обслуживания " + b);
                synchronized (b) {
                    b.notify();
                }
            }
            else
                //если пока нет работы, отдадим управление другим потокам
                Thread.yield();
        }
        System.out.println(this+"закрыл кассу.");
    }

    @Override
    public String toString() {
        return "Cashier: Кассир №" + number + " ";
    }
}
