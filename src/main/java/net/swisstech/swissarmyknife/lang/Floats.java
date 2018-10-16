package net.swisstech.swissarmyknife.lang;

//TODO structurally exactly the same as Longs, Bytes, Integers, Shorts etc...
//have 1 master and generate the rest!! Characters are the only signed type

/**
 * some float number utils
 *
 * @since 1.1.4
 */
public final class Floats {

	/**
	 * private constructor for utility class
	 */
	private Floats() {
	}

	public static boolean isZero(float v) {
		return v == 0;
	}

	public static float zero(float v) {
		if (isZero(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected float to equal 0 but got " + v);
	}

	public static boolean isPositive(float v) {
		return v > 0;
	}

	public static float positive(float v) {
		if (isPositive(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected float to be positive but got " + v);
	}

	public static boolean isNegative(float v) {
		return v < 0;
	}

	public static float negative(float v) {
		if (isNegative(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected float to be negative but got " + v);
	}

	public static boolean isZeroOrPositive(float v) {
		return v >= 0;
	}

	public static float zeroOrPositive(float v) {
		if (isZeroOrPositive(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected float to be zero or positive but got " + v);
	}

	public static boolean isZeroOrNegative(float v) {
		return v <= 0;
	}

	public static float zeroOrNegative(float v) {
		if (isZeroOrNegative(v)) {
			return v;
		}
		throw new IllegalArgumentException("Expected float to be zero or negative but got " + v);
	}

	public static boolean isInRangeInclusive(float v, float lo, float hi) {
		return v >= lo && v <= hi;
	}

	public static float inRangeInclusive(float v, float lo, float hi) {
		if (isInRangeInclusive(v, lo, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " inclusive");
	}

	public static boolean isInRangeExclusive(float v, float lo, float hi) {
		return v > lo && v < hi;
	}

	public static float inRangeExclusive(float v, float lo, float hi) {
		if (isInRangeExclusive(v, lo, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " exclusive");
	}

	public static boolean isEqual(float exp, float act) {
		return exp == act;
	}

	public static float equal(float exp, float act) {
		if (isEqual(exp, act)) {
			return act;
		}
		throw new IllegalArgumentException("Expected " + act + " to equal to " + exp);
	}

	public static boolean isGreater(float v, float lo) {
		return v > lo;
	}

	public static float greater(float v, float lo) {
		if (isGreater(v, lo)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be greater than " + lo);
	}

	public static boolean isGreaterOrEqual(float v, float lo) {
		return v >= lo;
	}

	public static float greaterOrEqual(float v, float lo) {
		if (isGreaterOrEqual(v, lo)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be greater or equal to " + lo);
	}

	public static boolean isSmaller(float v, float hi) {
		return v < hi;
	}

	public static float smaller(float v, float hi) {
		if (isSmaller(v, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be smaller than " + hi);
	}

	public static boolean isSmallerOrEqual(float v, float hi) {
		return v <= hi;
	}

	public static float smallerOrEqual(float v, float hi) {
		if (isSmallerOrEqual(v, hi)) {
			return v;
		}
		throw new IllegalArgumentException("Expected " + v + " to be smaller or equal to " + hi);
	}

	public static float limit(float v, float lo, float hi) {
		if (v < lo) {
			return lo;
		}
		if (v > hi) {
			return hi;
		}
		return v;
	}
}
