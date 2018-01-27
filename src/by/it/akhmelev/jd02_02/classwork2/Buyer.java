package by.it.akhmelev.jd02_02.classwork2;


class Buyer extends Thread implements IBuyer
{
    Buyer(int number) {
        super("Покупатель №"+number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
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
            String goodName= Goods.rndGoodName();
            Double goodPrice= Goods.getPrice(goodName);
            System.out.println(this+"выбрал товар "+goodName+" цена:"+goodPrice);
        }
        System.out.println(this+"завершил выбор товаров");
    }

    @Override
    public void goToQueue() {
        Dispatcher.addToQueue(this);
        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void goToOut() {
        System.out.println(this+"вышел из магазина");
        System.out.println("В очереди осталось "+Dispatcher.getSizeQueue());
    }

    @Override
    public String toString() {
        return this.getName()+" "; //"Покупатель №"+number
    }
}
