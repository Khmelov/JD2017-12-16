package by.it.karpeichyk.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class th3_00_Atomics extends Thread{

    private enum State {
        NEW, INITIALIZING, INITIALIZED
    }

    private AtomicInteger atomicCount =new AtomicInteger(0);

    //целостная ссылка на состояние
    private static final AtomicReference<State> init = new AtomicReference<>(State.NEW);

    public void run() {
        System.out.println("Step 0:"+init.get());
        if (!init.compareAndSet(State.NEW, State.INITIALIZING)) {
            throw new IllegalStateException("Already initialize");
        }
        System.out.println("Step 1:"+init.get());
        State prev=init.getAndSet(State.INITIALIZED);
        System.out.println("Step 2:"+init.get()+" prev:"+prev);
        atomicCount.getAndAdd(1);
    }

    public static void main(String[] args) throws InterruptedException {
        new th3_00_Atomics().start();
        new th3_00_Atomics().start();
        new th3_00_Atomics().start();
    }
}
