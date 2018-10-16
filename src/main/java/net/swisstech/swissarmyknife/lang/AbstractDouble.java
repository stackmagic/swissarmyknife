package net.swisstech.swissarmyknife.lang;

/**
 * base class for custom doubles (too bad java has no typedef construct)
 *
 * @since 1.1.4
 */
public class AbstractDouble extends Number implements Comparable<AbstractDouble> {

	private static final long serialVersionUID = 1724128146756984274L;

	private final double value;

	public AbstractDouble(double value) {
		this.value = value;
	}

	public AbstractDouble(String value) {
		this(Double.parseDouble(value));
	}

	@Override
	public int compareTo(AbstractDouble o) {
		//noinspection NumberEquality
		if (o == this) {
			return 0;
		}
		if (o == null) {
			return 1;
		}
		return Double.compare(value, o.value);
	}

	@Override
	public int intValue() {
		return (int) value;
	}

	@Override
	public long longValue() {
		return (long) value;
	}

	@Override
	public float floatValue() {
		return (float) value;
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
			return value == ((AbstractDouble) obj).value;
		}
		return false;
	}

	@Override
	public int hashCode() {
		long bits = Double.doubleToLongBits(value);
		return (int) (bits ^ (bits >>> 32));
	}

	@Override
	public String toString() {
		return Double.toString(value);
	}

}
