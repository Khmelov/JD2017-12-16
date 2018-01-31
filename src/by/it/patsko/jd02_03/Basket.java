package by.it.patsko.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Basket {
    public Basket() {
        System.out.println("Количество свободных корзинок = "+(30-numOfOccupiedBasket.incrementAndGet()));
    }

    static AtomicInteger numOfOccupiedBasket = new AtomicInteger();
    static final Semaphore BASKET_SEMAPHORE = new Semaphore(30);
    private Map<String, Double> goodsInBasket = new HashMap<>();
    boolean isBasketFull = goodsInBasket.size() == 4;

    public void addGoodsToBasket(String goodName, Double price) {
        goodsInBasket.put(goodName, price);
    }

    public Map<String, Double> getGoodsInBasket() {
        return goodsInBasket;
    }
}
