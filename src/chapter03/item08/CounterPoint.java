package chapter03.item08;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Noblel
 */
public class CounterPoint extends Point {
    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }

    public int numberCreated() {
        return counter.get();
    }
}