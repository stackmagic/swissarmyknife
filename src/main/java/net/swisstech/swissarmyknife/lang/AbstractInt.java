package net.swisstech.swissarmyknife.lang;

/**
 * base class for custom ints (too bad java has no typedef construct)
 *
 * @see AbstractCharSequence for more explanation of why this class exists
 *
 * @since 1.1.4
 */
public abstract class AbstractInt extends Number implements Comparable<AbstractInt> {

	private static final long serialVersionUID = -1418032099350169437L;

	private final int value;

	public AbstractInt(int value) {
		this.value = value;
	}

	public AbstractInt(String value) {
		this(Integer.parseInt(value));
	}

	@Override
	public int compareTo(AbstractInt o) {
		//noinspection NumberEquality
		if (o == this) {
			return 0;
		}
		if (o == null) {
			return 1;
		}
		return Integer.compare(value, o.value);
	}

	@Override
	public int intValue() {
		return value;
	}

	@Override
	public long longValue() {
		return value;
	}

	@Override
	public float floatValue() {
		return value;
	}

	@Override
	public double doubleValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		// must be an exact match
		if (obj != null && this.getClass() == obj.getClass()) {
			return value == ((AbstractInt) obj).value;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}
}
