package by.it.patsko.jd02_01;


class Buyer extends Thread implements IBuyer, IUseBasket {
    Basket basket;
    boolean pensioneer;

    Buyer(int number) {
        super("Покупатель №" + number);
        pensioneer = Helper.getRandom(4) == 0;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
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
            Helper.sleep(100, 200, pensioneer);
            String goodName = Goods.rndGoodName();
            Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this + " выбрал " + goodName + " за " + goodPrice + " рублей");
            if (!basket.isBasketFull) putGoodsToBasket(goodName, goodPrice);
            else break;
        }
        System.out.println(this + " закончил выбирать товары");
    }

    @Override
    public void goToOut() {
        // TODO: synh
        Runner.queue.remove(this);
        System.out.println(this + " вышел из магазина");
        System.out.println("В очереди осталось" + Runner.queue.size());
    }

    @Override
    public String toString() {
        return this.getName()+(pensioneer?"(пенсионер)":"");
    }

    //IUseBasket
    @Override
    public void takeBasket() {
        basket = new Basket();
        Helper.sleep(100, 200, pensioneer);
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBasket(String name, Double price) {
        System.out.println(this + " положил " + name + " за " + price + " рублей в корзину");
        basket.addGoodsToBasket(name, price);
        Helper.sleep(100, 200, pensioneer);
    }
}
