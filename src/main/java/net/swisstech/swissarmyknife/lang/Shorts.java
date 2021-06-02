package net.swisstech.swissarmyknife.lang;

//TODO structurally exactly the same as Longs, Bytes, Integers, Shorts etc...
//have 1 master and generate the rest!! Characters are the only signed type
// only Characters doesn't have a "parseCharacter" method

/**
 * some short number utils
 *
 * @since 1.2.0
 */
public final class Shorts {

    /** private constructor for utility class */
    private Shorts() {
    }

    public static Short tryParse(String text, Short def) {
        if (text == null) {
            return def;
        }
        try {
            return Short.parseShort(text);
        } catch (NumberFormatException e) {
            return def;
        }
    }

    public static Short tryParse(String text) {
        return tryParse(text, null);
    }

    public static boolean isZero(short v) {
        return v == 0;
    }

    public static short zero(short v) {
        if (isZero(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected short to equal 0 but got " + v);
    }

    public static boolean isPositive(short v) {
        return v > 0;
    }

    public static short positive(short v) {
        if (isPositive(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected short to be positive but got " + v);
    }

    public static boolean isNegative(short v) {
        return v < 0;
    }

    public static short negative(short v) {
        if (isNegative(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected short to be negative but got " + v);
    }

    public static boolean isZeroOrPositive(short v) {
        return v >= 0;
    }

    public static short zeroOrPositive(short v) {
        if (isZeroOrPositive(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected short to be zero or positive but got " + v);
    }

    public static boolean isZeroOrNegative(short v) {
        return v <= 0;
    }

    public static short zeroOrNegative(short v) {
        if (isZeroOrNegative(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected short to be zero or negative but got " + v);
    }

    public static boolean isInRangeInclusive(short v, short lo, short hi) {
        return v >= lo && v <= hi;
    }

    public static short inRangeInclusive(short v, short lo, short hi) {
        if (isInRangeInclusive(v, lo, hi)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " inclusive");
    }

    public static boolean isInRangeExclusive(short v, short lo, short hi) {
        return v > lo && v < hi;
    }

    public static short inRangeExclusive(short v, short lo, short hi) {
        if (isInRangeExclusive(v, lo, hi)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " exclusive");
    }

    public static boolean isEqual(short exp, short act) {
        return exp == act;
    }

    public static short equal(short exp, short act) {
        if (isEqual(exp, act)) {
            return act;
        }
        throw new IllegalArgumentException("Expected " + act + " to equal to " + exp);
    }

    public static boolean isGreater(short v, short lo) {
        return v > lo;
    }

    public static short greater(short v, short lo) {
        if (isGreater(v, lo)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be greater than " + lo);
    }

    public static boolean isGreaterOrEqual(short v, short lo) {
        return v >= lo;
    }

    public static short greaterOrEqual(short v, short lo) {
        if (isGreaterOrEqual(v, lo)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be greater or equal to " + lo);
    }

    public static boolean isSmaller(short v, short hi) {
        return v < hi;
    }

    public static short smaller(short v, short hi) {
        if (isSmaller(v, hi)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be smaller than " + hi);
    }

    public static boolean isSmallerOrEqual(short v, short hi) {
        return v <= hi;
    }

    public static short smallerOrEqual(short v, short hi) {
        if (isSmallerOrEqual(v, hi)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be smaller or equal to " + hi);
    }

    public static short limit(short v, short lo, short hi) {
        if (v < lo) {
            return lo;
        }
        if (v > hi) {
            return hi;
        }
        return v;
    }
}
