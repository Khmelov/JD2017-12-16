package by.it.karpeichyk.jd02_03;

/**
 * Created by user on 25.01.2018.
 */
public interface iByer {
void enterToMarket(); // вошёл в магазин мгновенно
    void chooseGoods();//выбрал товар(0,2 - 5 сек)
    void goToQueue();
    void goToOut();// вышел из магазина
}
