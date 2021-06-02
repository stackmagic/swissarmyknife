package net.swisstech.swissarmyknife.lang;

import static net.swisstech.swissarmyknife.lang.Longs.limit;
import static net.swisstech.swissarmyknife.lang.Longs.smaller;

public class BoundedLong {

    private final long min;
    private final long max;

    private long value;

    public BoundedLong(long min, long max) {
        this(min, max, 0);
    }

    public BoundedLong(long min, long max, long value) {
        this.min = min;
        this.max = max;
        smaller(min, max);
        set(value);
    }

    public long set(long newValue) {
        value = limit(newValue, min, max);
        return value;
    }

    public long increment() {
        return plus(1);
    }

    public long decrement() {
        return minus(1);
    }

    public long plus(long diff) {
        return set(value + diff);
    }

    public long minus(long diff) {
        return set(value - diff);
    }

    public long multiply(long factor) {
        return set(value * factor);
    }

    public long divide(long divisor) {
        return set(value / divisor);
    }

    public long getMin() {
        return min;
    }

    public long setMin() {
        return set(min);
    }

    public long getMax() {
        return max;
    }

    public long setMax() {
        return set(max);
    }

    public long get() {
        return value;
    }
}
