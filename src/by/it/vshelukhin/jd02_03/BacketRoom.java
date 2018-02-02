package by.it.vshelukhin.jd02_03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BacketRoom {
    static final int NUM_BACKETS = 30;

    static final BlockingQueue<Backet> backetAll = new LinkedBlockingDeque<>(NUM_BACKETS);

    static {
        for (int i = 0; i < NUM_BACKETS; i++) {
            backetAll.add(new Backet(Integer.toString(i + 1)));
        }
    }

    static Backet getBacked() {
        return backetAll.poll();
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
