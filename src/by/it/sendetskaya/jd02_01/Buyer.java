package by.it.sendetskaya.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket, Comparable<Buyer>{

    private boolean pensioneer;
    static double sum=0;

    public Buyer(int number, boolean pensioneer)
    {
        super("Покупатель №" + number);
        this.pensioneer=pensioneer;
//        if (pensioneer) {
//            System.out.println("Покупатель - пенсионер №" +number);
//        }
    }


    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        if(pensioneer) {
            Helper.sleep(150, 300);
            System.out.println(this+"зашел в магазин пенсионер");
        }
        else {
            Helper.sleep(100, 200);
            System.out.println(this + "зашел в магазин");
        }
    }

    @Override
    public void takeBacket() {
        if(pensioneer) {
            Helper.sleep(150, 300);
            System.out.println(this+"взял корзину пенсионер");
        }
        else {
            Helper.sleep(100, 200);
            System.out.println(this + "взял корзину");
        }
    }

    @Override
    public void chooseGoods() {

        for (int i = 1; i < Helper.getRandom(5); i++) {
            if(pensioneer) {
                Helper.sleep(150, 300);
                String goodName = Goods.getGoodName();
                Double goodPrice = Goods.getPrice(goodName);
                System.out.println(this + "пенсионер выбрал товар " + goodName + " цена: " + goodPrice);
                sum+=goodPrice;
            }
            else {
                Helper.sleep(100, 200);
                String goodName = Goods.getGoodName();
                Double goodPrice = Goods.getPrice(goodName);
                System.out.println(this + "выбрал товар " + goodName + " цена: " + goodPrice);
                sum+=goodPrice;
            }
            //putGoodsToBacket();
        }
        System.out.println(this+"закончил выбор");
    }

    @Override
    public void goToOut() {
        //Runner.queue.remove(this);

        System.out.println(this+"вышел из магазина");
        //в принципе уменьшать счетчик может и кассир,
        //но этот код позднее, поэтому уменьшаем тут
        Dispetcher.incCompleteBuyer();
        Dispetcher.printCounts();
        System.out.println("В очереди осталось "+Dispetcher.getSizeQueque());
    }

    @Override
    public void goToQueue() {
        Dispetcher.addLastToQueue(this);
        synchronized (this)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.err.println(this+" неожиданная ошибка !!!");
            }
        }
    }

    @Override
    public String toString() {

        if (pensioneer) {
            return "Пенсионер-"+this.getName()+" ";
        }
        else
            return this.getName()+" ";  //покупатель №+number
    }


    @Override
    public void putGoodsToBacket() {

        if(pensioneer)
            Helper.sleep(150,300);
        else
        Helper.sleep(100,200);
        System.out.println(this +" положил в корзину на сумму "+sum);

    }


    //доделать 0,-1,1(пенс)
    @Override
    public int compareTo(Buyer o) {
        int comp=0;
        if(!this.pensioneer&&o.pensioneer) comp=1;
        if(this.pensioneer&&o.pensioneer) comp=0;
        if(this.pensioneer&&!o.pensioneer) comp=-1;
        if(!this.pensioneer&&!o.pensioneer) comp=0;
        return comp;
    }
}
