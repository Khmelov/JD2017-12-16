package by.it.viktorbrui.jd02_02;

public interface IBuyerI {

    void enterToMarket();    //вошел в магазин (мгновенно)

    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)

    void goToQueue();        //встать в очередь

    void goToOut();          //отправился на выход(мгновенно)
}
