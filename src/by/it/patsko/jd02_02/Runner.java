package by.it.patsko.jd02_02;


class Runner {

    public static void main(String[] args) throws InterruptedException {
        /*MyStopwatch stopwatch = new MyStopwatch();
        stopwatch.setDaemon(true);
        stopwatch.start();*/

        Cashier[] cashier = new Cashier[5];

        for (int minutes = 0; minutes < 2; minutes++) {
            for (int second = 0; second < 60; second++) {
//                System.out.println("\nВ "+Cashier.getNumOfCashiers()+ " ОЧЕРЕДЯХ "+Queue.getQueueSize()+" ЧЕЛОВЕК\n");
                if (Cashier.getNumOfCashiers() < 5 && Queue.getQueueSize() > 5 * Cashier.getNumOfCashiers()) {
                    cashier[Cashier.getNumOfCashiers()] = new Cashier(Cashier.getNumOfCashiers() + 1);
                    new Thread(cashier[Cashier.getNumOfCashiers()]).start();
                }
                if (Cashier.getNumOfCashiers() > 0 && Queue.getQueueSize() < 5 * Cashier.getNumOfCashiers()) {
                    cashier[Cashier.getNumOfCashiers() - 1].setIsOpen(false);
                }

                int count = Helper.getRandomCustomers(second);
                for (int i = 0; i <= count; i++) {
                    Buyer b = new Buyer(Queue.incNumOfAllCustomers());
                    b.start();
                }
                Thread.sleep(100);
            }
        }
        while (!Queue.allBuyerComplete()) {
            Buyer customer = Queue.getPensionerQueueSize() == 0 ? Queue.readFirstQueue() : Queue.readFirstPensionerQueue();
            if (customer != null) {
                customer.join();
            }
        }
        System.out.println("Все вышли");
        Helper.sleep(100, 200);
        System.out.println("\nколичество покупателей в очереди:" + Queue.getQueueSize() +
                "\nколичество обслуженных покупателей:" + Queue.getNumOfServedCustomers()+
                "\nколичество покупателей всего:" + Queue.getNumOfAllCustomers());
    }
}
