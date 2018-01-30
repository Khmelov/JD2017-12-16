package by.it.viktorbrui.jd02_01;


class Buyer extends Thread implements IBuyer, IUseBacket
{
    Buyer(int number) {
        super("Покупатель №"+number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToOut();


    }
    @Override
    public void enterToMarket() {
        System.out.println(this+"зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i <= Helper.getRandom(5); i++) {
            Helper.sleep(100,200);
            String goodName=Goods.rndGoodName();
            Double goodPrice=Goods.getPrice(goodName);
            System.out.println(this+"выбрал товар "+goodName+" цена:"+goodPrice);
        }
        System.out.println(this+"завершил выбор товаров");
}

    @Override
    public void takeBacket() {
        System.out.println(Buyer.this+"взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        System.out.println(this+"положил выбранный товар в корзину");
    }
    @Override
    public void goToOut() {
        //todo all is bad (sync)
        Runner.queue.remove(this);
        System.out.println(this+"вышел из магазина");
        System.out.println("В очереди осталось "+ Runner.queue.size());
    }

    @Override
    public String toString() {
        return this.getName()+" "; //"Покупатель №"+number
    }
}
