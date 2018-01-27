package by.it.patsko.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<String, Double> goodsInBasket = new HashMap<>();
    boolean isBasketFull;

    public void addGoodsToBasket(String goodName, Double price) {
        goodsInBasket.put(goodName, price);
        if (goodsInBasket.size() == 4) isBasketFull = true;
    }
}
