package by.it.sendetskaya.jd02_01;


import java.util.Map;

public class Cashier implements Runnable{

    private int number;


    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cashier: Кассир №" + number+" ";
    }


    @Override
    public void run() {

        Buyer b;
        do {

            while (!Dispetcher.allBuyerComplete()) {

                if (Queue.getSizeQueue() / 5 >= Queue.getCashierQueueSize() || Queue.getCashierQueueSize() == 0) {
                    Queue.addCashierToQueue(this);
                    System.out.println(this + "открыл кассу.");
                }
                if (Queue.inclQueueCashier(this)) {

                    b = Queue.delFirstFromQueue();
                    if (b != null) {
                        System.out.println(this + "Начало обслуживания покупателя " + b);
                        Helper.sleep(200, 500);

                        synchronized (b){
                            printBuild(b);
                        }
                        Helper.sleep(200, 500);
                        System.out.println(this + "Конец обслуживания покупателя " + b);
                        synchronized (b) {
                            b.notify();
                        }
                        Queue.delBacketFromQueue(b);
//
                        if (Queue.getSizeQueue() / 5 < Queue.getCashierQueueSize()) {
                            Queue.delCashierFromQueue();
                            System.out.println(this + "закрыл кассу.");
                            Thread.yield();
                        }
                    } else
                        //если пока нет работы, отдадим управление другим потокам
                        Thread.yield();
                }
            }
        }
        while (!Dispetcher.planComplete());
        if (Queue.getCashierQueueSize()>0) {
            Queue.delCashierFromQueue();
        }
    }

    private synchronized void printBuild(Buyer b) {

        double sum=0, price;
        String name;

        System.out.println(this + "печатаем чек для " + b + ":");

        System.out.printf("Кассы |%10s|%10s|%10s|%10s|%10s|%5s|\n","1","2","3","4","5","Сумма");
        System.out.println("--------------------------------------------------------------------");
        int choose=this.number;

        for (Map.Entry<String, Double> entry: Buyer.hashMap.entrySet())
        {
            price=entry.getValue();
            name=entry.getKey();
            String print=name+"="+price;

            switch (choose)
            {

                case 1:
                    System.out.printf("      |%10s|%10s|%10s|%10s|%10s|%5s|\n", print, "", "", "", "", "");
                    break;
                case 2:
                    System.out.printf("      |%10s|%10s|%10s|%10s|%10s|%5s|\n", "", print, "", "", "", "");
                    break;
                case 3:
                    System.out.printf("      |%10s|%10s|%10s|%10s|%10s|%5s|\n", "", "", print, "", "", "");
                    break;
                case 4:
                    System.out.printf("      |%10s|%10s|%10s|%10s|%10s|%5s|\n", "", "", "", print, "", "");
                    break;
                case 5:
                    System.out.printf("      |%10s|%10s|%10s|%10s|%10s|%5s|\n", "", "", "", "", print, "");
                    break;
                    default:
                        System.out.println("Непредвиденная ошибка!");
                    break;
            }
            sum+=price;
        }
        System.out.printf("Сумма |%10s|%10s|%10s|%10s|%10s|%5s|\n", "", "", "", "", "", sum);

        System.out.println("--------------------------------------------------------------------");
    }

}
