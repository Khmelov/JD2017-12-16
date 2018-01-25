package by.it.patsko.jd02_01;


interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)

    void chooseGoods(); //выбрал товар (от 0,1 до 0,2 секунд)

    void goToOut(); //отправился на выход(мгновенно)
}

