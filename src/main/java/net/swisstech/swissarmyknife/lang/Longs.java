package net.swisstech.swissarmyknife.lang;

//TODO structurally exactly the same as Longs, Bytes, Integers, Shorts etc...
//have 1 master and generate the rest!! Characters are the only signed type

/**
 * some long number utils
 * @since 1.1.4
 */
public final class Longs {

	/** private constructor for utility class */
	private Longs() {}

	public static boolean isZero(long v) {
		return v == 0;
	}

	public static long zero(long v) {
		if (isZero(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected long to equal 0 but got " + v);
	}

	public static boolean isPositive(long v) {
		return v > 0;
	}

	public static long positive(long v) {
		if (isPositive(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected long to be positive but got " + v);
	}

	public static boolean isNegative(long v) {
		return v < 0;
	}

	public static long negative(long v) {
		if (isNegative(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected long to be negative but got " + v);
	}

	public static boolean isZeroOrPositive(long v) {
		return v >= 0;
	}

	public static long zeroOrPositive(long v) {
		if (isZeroOrPositive(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected long to be zero or positive but got " + v);
	}

	public static boolean isZeroOrNegative(long v) {
		return v <= 0;
	}

	public static long zeroOrNegative(long v) {
		if (isZeroOrNegative(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected long to be zero or negative but got " + v);
	}

	public static boolean isInRangeInclusive(long v, long lo, long hi) {
		return v >= lo && v <= hi;
	}

	public static long inRangeInclusive(long v, long lo, long hi) {
		if (isInRangeInclusive(v, lo, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " inclusive");
	}

	public static boolean isInRangeExclusive(long v, long lo, long hi) {
		return v > lo && v < hi;
	}

	public static long inRangeExclusive(long v, long lo, long hi) {
		if (isInRangeExclusive(v, lo, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " exclusive");
	}

	public static boolean isEqual(long exp, long act) {
		return exp == act;
	}

	public static long equal(long exp, long act) {
		if (isEqual(exp, act)) {
			return act;
		}
		throw new IllegalArgumentException("Expected " + act + " to equal to " + exp);
	}

	public static boolean isGreater(long v, long lo) {
		return v > lo;
	}

	public static long greater(long v, long lo) {
		if (isGreater(v, lo)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be greater than " + lo);
	}

	public static boolean isGreaterOrEqual(long v, long lo) {
		return v >= lo;
	}

	public static long greaterOrEqual(long v, long lo) {
		if (isGreaterOrEqual(v, lo)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be greater or equal to " + lo);
	}

	public static boolean isSmaller(long v, long hi) {
		return v < hi;
	}

	public static long smaller(long v, long hi) {
		if (isSmaller(v, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be smaller than " + hi);
	}

	public static boolean isSmallerOrEqual(long v, long hi) {
		return v <= hi;
	}

	public static long smallerOrEqual(long v, long hi) {
		if (isSmallerOrEqual(v, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be smaller or equal to " + hi);
	}

	public static long limit(long v, long lo, long hi) {
		if (v < lo) {
			return lo;
		}
		if (v > hi) {
			return hi;
		}
		return v;
	}
}
