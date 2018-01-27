package by.it.ikiselev.jd02_01;


class Buyer extends Thread implements IBuyer, IUseBacket
{
    Backet backet;
    boolean pensioneer;
    Buyer(int number) {
        super("Покупатель №"+number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putsGoodsToBacket();
        goToOut();
        Runner.countBuyer=Runner.countBuyer-1;
    }

    @Override
    public void enterToMarket() {
        if (this.pensioneer)        System.out.println(this+" - пенсионер- зашел в магазин");
        else System.out.println(this+" зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i <= Helper.getRandom(5); i++) {
            if (this.pensioneer) Helper.sleep(100,300);
            else Helper.sleep(100,200);
            String goodName=Goods.rndGoodName();
            backet.add(goodName);
            Double goodPrice=Goods.getPrice(goodName);
            System.out.println(this+"выбрал товар "+goodName+" цена:"+goodPrice);
        }
        System.out.println(this+"завершил выбор товаров");
    }

    @Override
    public void goToOut() {
        //todo all is bad (sync)
        Runner.queue.remove(this);
        System.out.println(this+"вышел из магазина");
        System.out.println("В очереди осталось "+Runner.queue.size());

    }

    @Override
    public String toString() {
        return this.getName()+" "; //"Покупатель №"+number
    }

    @Override
    public void takeBacket() {
        if (this.pensioneer) Helper.sleep(100,300);
        else Helper.sleep(100,200);
        backet=new Backet();
        System.out.println(this+" взял корзину");

    }

    @Override
    public void putsGoodsToBacket() {
        if (this.pensioneer) Helper.sleep(100,300);
        else Helper.sleep(100,200);
        if (this.backet.isEmpty()) System.out.println(this+" ничего не положил в корзину ");
        else System.out.println(this+" положил в корзину "+backet);
    }
}
