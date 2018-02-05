package by.it.akhmelev.jd02_02.classwork2;

interface IBuyer {

    void enterToMarket();    //вошел в магазин (мгновенно)

    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)

    void goToQueue();        //встал в очередь

    void goToOut();          //отправился на выход(мгновенно)
}
