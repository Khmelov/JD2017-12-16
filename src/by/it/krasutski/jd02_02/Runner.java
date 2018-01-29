package by.it.krasutski.jd02_02;


class Runner {

    public static void main(String[] args) throws InterruptedException {

        Cashier[] cashier = new Cashier[5];

        for (int second = 0; second < 60; second++) {
            if (Cashier.getNumOfCashiers() < 5 && Dispatcher.getQueueSize() > 5 * Cashier.getNumOfCashiers()) {
                cashier[Cashier.getNumOfCashiers()] = new Cashier(Cashier.getNumOfCashiers() + 1);
                new Thread(cashier[Cashier.getNumOfCashiers()]).start();
            }
            if (Cashier.getNumOfCashiers() > 0 && Dispatcher.getQueueSize() < 5 * Cashier.getNumOfCashiers()) {
                cashier[Cashier.getNumOfCashiers() - 1].setIsOpen(false);
            }

            int count = Helper.getRandom(5);
            for (int i = 0; i <= count; i++) {
                Buyer b = new Buyer(Dispatcher.incNumOfAllCustomers());
                b.start();
            }
            Thread.sleep(100);
        }
        while (!Dispatcher.allBuyerComplete()) {
            Buyer customer = Dispatcher.getPensionerQueueSize() == 0
                    ? Dispatcher.readFirstQueue() :
                    Dispatcher.readFirstPensionerQueue();
            if (customer != null) {
                customer.join();
            }
        }
        System.out.println("Все вышли.");
        Helper.sleep(100, 200);
        System.out.println("Количество покупателей в очереди: " + Dispatcher.getQueueSize() + ".");
        if (Dispatcher.getNumOfServedCustomers() == Dispatcher.getNumOfAllCustomers())
            System.out.println("Магазин закрыт.\n");
        System.out.println("Количество обслуженных покупателей: " + Dispatcher.getNumOfServedCustomers() + ".");
        System.out.println("Количество покупателей всего: " + Dispatcher.getNumOfAllCustomers() + ".");
        System.out.println("Выручка магазина составила " + Cashier.totalSum + " рублей.");
    }
}
