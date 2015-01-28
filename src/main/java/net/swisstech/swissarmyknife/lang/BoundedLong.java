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
		return set(value + 1);
	}

	public long decrement() {
		return set(value - 1);
	}

	public long get() {
		return value;
	}
}
