package by.it.krasutski.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioner = false;

    Buyer(int number) {
        super("Покупатель №" + number);
    }

    private void buyerType() {
        if (Helper.getRandom(4) == 0)
            pensioner = true;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        buyerType();
        if (pensioner)
            System.out.println(this + "(пенсионер) зашел в магазин.");
        else
            System.out.println(this + "зашел в магазин.");

    }

    @Override
    public void takeBasket() {
        Helper.sleep(100,200);
        System.out.println(this + "взял корзину.");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i <= Helper.getRandom(5) ; i++) {
            Helper.sleep(500,2000, pensioner);
            String goodName = Goods.rndGoodName();
            Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this + "выбрал товар " + goodName + " цена: " + goodPrice + ".");
        }
        System.out.println(this + "завершил выбор.");
    }

    @Override
    public void putGoodsToBasket() {
        Helper.sleep(100,200);
        System.out.println(this + "положил товары в корзину.");
    }

    @Override
    public void goToOut() {
        //TODO need sync
        Runner.queue.remove(this);
        System.out.println(this + "вышел из магазина.");
        System.out.println("В очереди осталось " + Runner.queue.size() + ".");
    }

    @Override
    public String toString() {
        return this.getName() + " ";
    }
}
