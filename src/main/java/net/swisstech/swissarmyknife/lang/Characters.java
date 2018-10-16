package net.swisstech.swissarmyknife.lang;

// TODO structurally exactly the same as Longs, Bytes, Integers, Shorts etc...
// have 1 master and generate the rest!! Characters are the only signed type

/**
 * some char number utils
 *
 * @since 1.2.0
 */
public final class Characters {

	/**
	 * private constructor for utility class
	 */
	private Characters() {
	}

	public static boolean isZero(char v) {
		return v == 0;
	}

	public static char zero(char v) {
		if (isZero(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected char to equal 0 but got " + v);
	}

	public static boolean isPositive(char v) {
		return v > 0;
	}

	public static char positive(char v) {
		if (isPositive(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected char to be positive but got " + v);
	}

	public static boolean isInRangeInclusive(char v, char lo, char hi) {
		return v >= lo && v <= hi;
	}

	public static char inRangeInclusive(char v, char lo, char hi) {
		if (isInRangeInclusive(v, lo, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " inclusive");
	}

	public static boolean isInRangeExclusive(char v, char lo, char hi) {
		return v > lo && v < hi;
	}

	public static char inRangeExclusive(char v, char lo, char hi) {
		if (isInRangeExclusive(v, lo, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " exclusive");
	}

	public static boolean isEqual(char exp, char act) {
		return exp == act;
	}

	public static char equal(char exp, char act) {
		if (isEqual(exp, act)) {
			return act;
		}
		throw new IllegalArgumentException("Expected " + act + " to equal to " + exp);
	}

	public static boolean isGreater(char v, char lo) {
		return v > lo;
	}

	public static char greater(char v, char lo) {
		if (isGreater(v, lo)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be greater than " + lo);
	}

	public static boolean isGreaterOrEqual(char v, char lo) {
		return v >= lo;
	}

	public static char greaterOrEqual(char v, char lo) {
		if (isGreaterOrEqual(v, lo)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be greater or equal to " + lo);
	}

	public static boolean isSmaller(char v, char hi) {
		return v < hi;
	}

	public static char smaller(char v, char hi) {
		if (isSmaller(v, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be smaller than " + hi);
	}

	public static boolean isSmallerOrEqual(char v, char hi) {
		return v <= hi;
	}

	public static char smallerOrEqual(char v, char hi) {
		if (isSmallerOrEqual(v, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be smaller or equal to " + hi);
	}

	public static char limit(char v, char lo, char hi) {
		if (v < lo) {
			return lo;
		}
		if (v > hi) {
			return hi;
		}
		return v;
	}
}
