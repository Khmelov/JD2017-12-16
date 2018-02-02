package by.it.patsko.jd02_03;


import java.util.concurrent.atomic.AtomicInteger;

class Buyer extends Thread implements IBuyer, IUseBasket, Comparable<Buyer> {
    private Basket basket;
    private boolean pensioner;
    private final static AtomicInteger numberInQueueCounter=new AtomicInteger(0);
    private int numberInQueue;

    Buyer(int number) {
        super("Покупатель №" + number);
        pensioner = Helper.getRandom(4) == 0;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public Basket getBasket() {
        return basket;
    }

    @Override
    public void run() {
        enterToMarket();
        try {
            long start = System.nanoTime();
            Basket.BASKET_SEMAPHORE.acquire();
            long end = System.nanoTime();
            System.out.println(this+" ждал корзину "+(end-start)/1000+" микросекунд");


            takeBasket();
            chooseGoods();
            goToQueue();
            goToOut();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Basket.BASKET_SEMAPHORE.release();
        }
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i <= Helper.getRandom(1, 5); i++) {
            System.out.println(this + " выбирает товар");
            Helper.sleep(100, 200, pensioner);
            String goodName = Goods.rndGoodName();
            Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this + " выбрал " + goodName + " за " + goodPrice + " рублей");
            putGoodsToBasket(goodName, goodPrice);
        }
        System.out.println(this + " закончил выбирать товары");
    }

    @Override
    public void goToQueue() {
//        System.out.println(this + " стал в очередь");
        numberInQueue=numberInQueueCounter.incrementAndGet();
        Queue.addBuyerToQueue(this);
//        System.out.println(Queue.queue);
//        System.out.println();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goToOut() {
        Basket.numOfOccupiedBasket.decrementAndGet();
//        System.out.println(this + " вышел из магазина");
        Queue.incNumOfServedCustomers();
        System.out.println("В очереди осталось " + Queue.getQueueSize());
    }

    @Override
    public String toString() {
        return this.getName() + (pensioner ? "(пенсионер)" : "");
    }

    //IUseBasket
    @Override
    public void takeBasket() {
        basket = new Basket();
        Helper.sleep(100, 200, pensioner);
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBasket(String name, Double price) {
        System.out.println(this + " положил " + name + " за " + price + " рублей в корзину");
        basket.addGoodsToBasket(name, price);
        Helper.sleep(100, 200, pensioner);
    }

    @Override
    synchronized public int compareTo(Buyer other) {
        if(this.isPensioner()&&other.isPensioner()){
            if(this.numberInQueue>other.numberInQueue)return 1;
            else return -1;
        }
        if(!this.isPensioner()&&!other.isPensioner()){
            if(this.numberInQueue>other.numberInQueue)return 1;
            else return -1;
        }
        if(this.isPensioner()&&!other.isPensioner())return -1;
        if(!this.isPensioner()&&other.isPensioner())return 1;

        /*if (this.isPensioner()) return other.isPensioner() ? (other.numberInQueue-this.numberInQueue) : -1;
        else return other.isPensioner() ? 1 : (other.numberInQueue-this.numberInQueue);*/
        return 0;
    }
}
