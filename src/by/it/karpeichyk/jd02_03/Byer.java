package by.it.karpeichyk.jd02_03;

/**
 * Created by user on 25.01.2018.
 */
 class Byer extends Thread implements iByer,Comparable<Byer>{
    public  Byer (int number){
        super("покупатель N"+ number);
    }
   @Override
   public  void run(){
        enterToMarket();
        chooseGoods();
      //  TakeBasket();
       // PutGoodsToBacket();
       goToQueue();
        goToOut();
   }
   @Override
   public void enterToMarket(){
       System.out.println(this+"зашёл в магазин");
   }

    @Override
    public void chooseGoods() {
        for (int i = 1; i < Helper.getRandom(5) ; i++) {
            Helper.sleep(100,200);
            String goodName= Goods.rndGoodName();
            Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this+"выбрал товар "+goodName+" цена:"+goodPrice);
        }

        System.out.println("Завершил выбор товаров");

    }

    @Override
    public void   goToQueue() {
        Dispatcher.addToQueue(this);
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.err.println(this + "неожиданная ошибка!!!");
            }
        }
    }



    @Override
    public  void goToOut(){
        System.out.println(this+"вышел из магазина");
        Dispatcher.incCommpleteByer();
        Dispatcher.printCounts();
    }
    @Override
    public String toString() {
        return this.getName()+" ";
    }
    @Override
    public int compareTo (Byer o){
        return 0;
    }
}
