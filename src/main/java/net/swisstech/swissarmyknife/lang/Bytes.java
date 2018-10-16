package net.swisstech.swissarmyknife.lang;

//TODO structurally exactly the same as Longs, Bytes, Integers, Shorts etc...
//have 1 master and generate the rest!! Characters are the only signed type
// only Characters doesn't have a "parseCharacter" method

/**
 * some byte number utils
 *
 * @since 1.2.0
 */
public final class Bytes {

	/**
	 * private constructor for utility class
	 */
	private Bytes() {
	}

	public static Byte tryParse(String text, Byte def) {
		if (text == null) {
			return def;
		}
		try {
			return Byte.parseByte(text);
		} catch (NumberFormatException e) {
			return def;
		}
	}

	public static Byte tryParse(String text) {
		return tryParse(text, null);
	}

	public static boolean isZero(byte v) {
		return v == 0;
	}

	public static byte zero(byte v) {
		if (isZero(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected byte to equal 0 but got " + v);
	}

	public static boolean isPositive(byte v) {
		return v > 0;
	}

	public static byte positive(byte v) {
		if (isPositive(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected byte to be positive but got " + v);
	}

	public static boolean isNegative(byte v) {
		return v < 0;
	}

	public static byte negative(byte v) {
		if (isNegative(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected byte to be negative but got " + v);
	}

	public static boolean isZeroOrPositive(byte v) {
		return v >= 0;
	}

	public static byte zeroOrPositive(byte v) {
		if (isZeroOrPositive(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected byte to be zero or positive but got " + v);
	}

	public static boolean isZeroOrNegative(byte v) {
		return v <= 0;
	}

	public static byte zeroOrNegative(byte v) {
		if (isZeroOrNegative(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected byte to be zero or negative but got " + v);
	}

	public static boolean isInRangeInclusive(byte v, byte lo, byte hi) {
		return v >= lo && v <= hi;
	}

	public static byte inRangeInclusive(byte v, byte lo, byte hi) {
		if (isInRangeInclusive(v, lo, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " inclusive");
	}

	public static boolean isInRangeExclusive(byte v, byte lo, byte hi) {
		return v > lo && v < hi;
	}

	public static byte inRangeExclusive(byte v, byte lo, byte hi) {
		if (isInRangeExclusive(v, lo, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " exclusive");
	}

	public static boolean isEqual(byte exp, byte act) {
		return exp == act;
	}

	public static byte equal(byte exp, byte act) {
		if (isEqual(exp, act)) {
			return act;
		}
		throw new IllegalArgumentException("Expected " + act + " to equal to " + exp);
	}

	public static boolean isGreater(byte v, byte lo) {
		return v > lo;
	}

	public static byte greater(byte v, byte lo) {
		if (isGreater(v, lo)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be greater than " + lo);
	}

	public static boolean isGreaterOrEqual(byte v, byte lo) {
		return v >= lo;
	}

	public static byte greaterOrEqual(byte v, byte lo) {
		if (isGreaterOrEqual(v, lo)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be greater or equal to " + lo);
	}

	public static boolean isSmaller(byte v, byte hi) {
		return v < hi;
	}

	public static byte smaller(byte v, byte hi) {
		if (isSmaller(v, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be smaller than " + hi);
	}

	public static boolean isSmallerOrEqual(byte v, byte hi) {
		return v <= hi;
	}

	public static byte smallerOrEqual(byte v, byte hi) {
		if (isSmallerOrEqual(v, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be smaller or equal to " + hi);
	}

	public static byte limit(byte v, byte lo, byte hi) {
		if (v < lo) {
			return lo;
		}
		if (v > hi) {
			return hi;
		}
		return v;
	}
}
