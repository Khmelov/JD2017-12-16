package by.it.viktorbrui.jd02_02;


class Buyer extends Thread implements IBuyer
{
    Buyer(int number) {
        super("Покупатель №"+number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+"зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i <= Helper.getRandom(4)+1; i++) {
            Helper.sleep(100,200);
            String goodName= Goods.rndGoodName();
            Double goodPrice= Goods.getPrice(goodName);
            System.out.println(this+"выбрал товар "+goodName+" цена:"+goodPrice);
        }
        System.out.println(this+"завершил выбор товаров");
    }

    @Override
    public void goToQueue() {
        //становимся в очередь
        Dispatcher.addToQueue(this);
        //тут синхронизируемся по своему монитору
        synchronized (this){
            try {
                //и останавливаемся (запускать поток будет уже кассир)
                this.wait();
            } catch (InterruptedException e) {
                System.err.println(this+" неожиданная ошибка !!!");
            }
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this+"вышел из магазина");
        //в принципе уменьшать счетчик может и кассир,
        //но этот код позднее, поэтому уменьшаем тут
        Dispatcher.incCompleteBuyer();
        Dispatcher.printCounts();
    }

    @Override
    public String toString() {
        return this.getName()+" "; //"Покупатель №"+number
    }
}
