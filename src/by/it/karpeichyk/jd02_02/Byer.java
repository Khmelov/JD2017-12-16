package by.it.karpeichyk.jd02_02;

/**
 * Created by user on 25.01.2018.
 */
 class Byer extends Thread implements iByer,Backet {

    public  Byer (int number){
        super("покупатель N"+ number);
    }
   @Override
   public  void run(){
        enterToMarket();
        chooseGoods();
        TakeBasket();
       PutGoodsToBacket();
       goToQueue();
        goToOut();
   }
   @Override
   public void enterToMarket(){
       System.out.println(this+"зашёл в магазин");
   }

    @Override
    public void chooseGoods() {
        for (int i = 2; i < Helper.getRandom(5) ; i++) {
            Helper.sleep(100,200);
            String goodName= Goods.rndGoodName();
            Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this+"выбрал товар "+goodName+" цена:"+goodPrice);
        }

        System.out.println("Завершил выбор товаров");

    }
    @Override
    public void TakeBasket(){
        by.it.karpeichyk.jd02_02.Helper.sleep(100,200);
        System.out.println(this+"взял корзину");
    }
    @Override
    public  void   PutGoodsToBacket(){
        for (int i = 2; i < by.it.karpeichyk.jd02_02.Helper.getRandom(5) ; i++) {
            by.it.karpeichyk.jd02_02.Helper.sleep(100,200);
            String goodName= by.it.karpeichyk.jd02_02.Goods.rndGoodName();
            Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this+"товар "+goodName+" цена" + goodPrice+ " положил в корзину");
        }
        // System.out.println("полным полна корзина");
    }

    @Override
    public void   goToQueue(){
       Dispatcher.addToQueue(this );
       synchronized (this){
           try {
               this.wait();
           }catch (InterruptedException e){
               System.err.println( this+"неожиданная ошибка!!!");
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
}
