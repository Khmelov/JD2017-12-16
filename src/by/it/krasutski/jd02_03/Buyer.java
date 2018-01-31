package by.it.krasutski.jd02_03;

public class Buyer extends Thread implements IBuyer, IUseBasket, Comparable<Buyer> {

    private Basket basket;
    private boolean pensioner = false;

    Buyer(int number) {
        super(String.format("Покупатель №%d", number));
        if (Helper.getRandom(4) == 3) pensioner = true;
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
        while (!Dispatcher.permitToEnterTradingHall()) {
            Thread.yield();
        }
        System.out.println(this + " зашёл в магазин.");
    }

    @Override
    public void takeBasket() {
        while (!Dispatcher.getFreeBasket()) {
            Thread.yield();
        }
        basket = new Basket();
        Helper.sleep(100, 200, pensioner);
        System.out.println(this + " взял корзину.");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i <= Helper.getRandom(1, 5); i++) {
            Helper.sleep(500, 2000, pensioner);
            String goodName = Goods.rndGoodName();
            Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this + " выбрал товар " + goodName + " за " + goodPrice + " рублей.");
            putGoodsToBasket(goodName, goodPrice);
        }
        System.out.println(this + " закончил выбирать товары.");
    }

    @Override
    public void putGoodsToBasket(String name, Double price) {
        System.out.println(this + " положил " + name + " за " + price + " рублей в корзину.");
        basket.addGoodsToBasket(name, price);
        Helper.sleep(100, 200, pensioner);
    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            while (!Dispatcher.addToQueue(this)) {
                this.chooseGoods();
            }
            try {
                Dispatcher.goFromTradingHall();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goToOut() {
        Dispatcher.returnBasket(this);
        Dispatcher.addServicedBuyer();
        System.out.println(this + " вышел из магазина.");
    }

    @Override
    public String toString() {
        if (pensioner) return this.getName() + " (пенсионер)";
        return this.getName() + "";
    }

    @Override
    public int compareTo(Buyer other) {
        if (this.pensioner) {
            if (other.pensioner) return 0;
            else return -1;
        } else {
            if (other.pensioner) return 1;
            else return 0;
        }
    }
}
