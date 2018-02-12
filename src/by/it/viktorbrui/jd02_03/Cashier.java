package by.it.viktorbrui.jd02_03;

public class Cashier implements Runnable {

    private int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + "открыл кассу.");
        while (!Dispatcher.allBuyerComplete()) {
            Buyer b = Dispatcher.extractFromQueue();
            //если есть покупатель, обслуживаем его
            if (b != null) {
                System.out.println(this + "Начало обслуживания " + b);
                Helper.sleep(200, 500);
                System.out.println(this + "печатаем чек для " + b);
                System.out.println(this + "Конец обслуживания " + b);
                synchronized (b) { //отправим покупателю команду выйти из wait
                    b.notify();
                }
            } else
                //если нет работы, отдадим управление другим потокам
                Thread.yield();
        }
        System.out.println(this + "закрыл кассу.");
    }

    @Override
    public String toString() {
        return "Cashier: Кассир №" + number + " ";
    }

    private void printCheck(Buyer buyer) {
        StringBuilder check = new StringBuilder();
        double sum = 0.0;



    }
}

