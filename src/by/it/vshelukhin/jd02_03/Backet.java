package by.it.vshelukhin.jd02_03;

import java.util.ArrayList;

public class Backet extends ArrayList<String> {

    String invNunb;

    Backet(String inv){
        invNunb = inv;
    }

    Backet(){
        invNunb = "?";
    }

    void addGoods(String name){
        this.add(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Номер корзинки: ");
        sb.append(invNunb);
        sb.append("\n");
        sb.append("В корзинке находится: \n");
        sb.append(super.toString());
        sb.append("\n");
        return sb.toString();
    }
}
