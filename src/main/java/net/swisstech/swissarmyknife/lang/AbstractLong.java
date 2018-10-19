package net.swisstech.swissarmyknife.lang;

/**
 * base class for custom ints (too bad java has no typedef construct)
 *
 * @see AbstractCharSequence for more explanation of why this class exists
 *
 * @since 1.1.4
 */
public abstract class AbstractLong extends Number implements Comparable<AbstractLong> {

	private static final long serialVersionUID = 6213649382515699446L;
	private final long value;

	public AbstractLong(long value) {
		this.value = value;
	}

	public AbstractLong(String value) {
		this(Long.parseLong(value));
	}

	@Override
	public int compareTo(AbstractLong o) {
		//noinspection NumberEquality
		if (o == this) {
			return 0;
		}
		if (o == null) {
			return 1;
		}
		return Long.compare(value, o.value);
	}

	@Override
	public int intValue() {
		return (int) value;
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
			return value == ((AbstractLong) obj).value;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (int) value;
	}

	@Override
	public String toString() {
		return Long.toString(value);
	}
}
