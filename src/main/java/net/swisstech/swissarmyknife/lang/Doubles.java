package net.swisstech.swissarmyknife.lang;

//TODO structurally exactly the same as Longs, Bytes, Integers, Shorts etc...
//have 1 master and generate the rest!! Characters are the only signed type

/**
 * some double number utils
 *
 * @since 1.2.0
 */
public final class Doubles {

	/**
	 * private constructor for utility class
	 */
	private Doubles() {
	}

	public static Double tryParse(String text, Double def) {
		if (text == null) {
			return def;
		}
		try {
			return Double.parseDouble(text);
		} catch (NumberFormatException e) {
			return def;
		}
	}

	public static Double tryParse(String text) {
		return tryParse(text, null);
	}

	public static boolean isZero(double v) {
		return v == 0;
	}

	public static double zero(double v) {
		if (isZero(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected double to equal 0 but got " + v);
	}

	public static boolean isPositive(double v) {
		return v > 0;
	}

	public static double positive(double v) {
		if (isPositive(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected double to be positive but got " + v);
	}

	public static boolean isNegative(double v) {
		return v < 0;
	}

	public static double negative(double v) {
		if (isNegative(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected double to be negative but got " + v);
	}

	public static boolean isZeroOrPositive(double v) {
		return v >= 0;
	}

	public static double zeroOrPositive(double v) {
		if (isZeroOrPositive(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected double to be zero or positive but got " + v);
	}

	public static boolean isZeroOrNegative(double v) {
		return v <= 0;
	}

	public static double zeroOrNegative(double v) {
		if (isZeroOrNegative(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected double to be zero or negative but got " + v);
	}

	public static boolean isInRangeInclusive(double v, double lo, double hi) {
		return v >= lo && v <= hi;
	}

	public static double inRangeInclusive(double v, double lo, double hi) {
		if (isInRangeInclusive(v, lo, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " inclusive");
	}

	public static boolean isInRangeExclusive(double v, double lo, double hi) {
		return v > lo && v < hi;
	}

	public static double inRangeExclusive(double v, double lo, double hi) {
		if (isInRangeExclusive(v, lo, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " exclusive");
	}

	public static boolean isEqual(double exp, double act) {
		return exp == act;
	}

	public static double equal(double exp, double act) {
		if (isEqual(exp, act)) {
			return act;
		}
		throw new IllegalArgumentException("Expected " + act + " to equal to " + exp);
	}

	public static boolean isGreater(double v, double lo) {
		return v > lo;
	}

	public static double greater(double v, double lo) {
		if (isGreater(v, lo)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be greater than " + lo);
	}

	public static boolean isGreaterOrEqual(double v, double lo) {
		return v >= lo;
	}

	public static double greaterOrEqual(double v, double lo) {
		if (isGreaterOrEqual(v, lo)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be greater or equal to " + lo);
	}

	public static boolean isSmaller(double v, double hi) {
		return v < hi;
	}

	public static double smaller(double v, double hi) {
		if (isSmaller(v, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be smaller than " + hi);
	}

	public static boolean isSmallerOrEqual(double v, double hi) {
		return v <= hi;
	}

	public static double smallerOrEqual(double v, double hi) {
		if (isSmallerOrEqual(v, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be smaller or equal to " + hi);
	}

	public static double limit(double v, double lo, double hi) {
		if (v < lo) {
			return lo;
		}
		if (v > hi) {
			return hi;
		}
		return v;
	}
}
