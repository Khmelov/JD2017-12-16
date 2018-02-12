package by.it.patsko.jd02_02;



class Buyer extends Thread implements IBuyer, IUseBasket {
    private Basket basket;
    private boolean pensioner;



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
        takeBasket();
        chooseGoods();
        goToQueue();
        goToOut();
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
//            if (!basket.isBasketFull) putGoodsToBasket(goodName, goodPrice);
//            else break;
        }
        System.out.println(this + " закончил выбирать товары");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " стал в очередь");
        Queue.addBuyerToQueue(this);

//        Queue.showQueue();
        System.out.println();
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
        System.out.println(this + " вышел из магазина");
        Queue.incNumOfServedCustomers();
        System.out.println("В очереди осталось" + Queue.getQueueSize());
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
}
