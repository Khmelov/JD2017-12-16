package by.it.vshelukhin.jd02_01;

import java.util.ArrayDeque;

public class BacketRoom {
    static ArrayDeque<Backet> backetAll = new ArrayDeque<Backet>() {
        @Override
        public String toString() {
            return super.toString().replace(",", "");
        }
    };

    static {
        for (int i = 0; i < 15; i++) {
            backetAll.add(new Backet(Integer.toString(i + 1)));
        }
    }

    static Backet getBacked() {
        return backetAll.pollLast();
    }

    static void acceptBacked(Backet b){
        b.clear();
        backetAll.add(b);
    }

    @Override
    public String toString() {
        return Integer.toString(backetAll.size());
    }
}
