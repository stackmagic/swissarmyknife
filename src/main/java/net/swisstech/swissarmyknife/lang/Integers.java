package net.swisstech.swissarmyknife.lang;

//TODO structurally exactly the same as Longs, Bytes, Integers, Shorts etc...
//  have 1 master and generate the rest!! Characters are the only unsigned type
//  only Characters doesn't have a "parseCharacter" method
//  https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

/**
 * some int number utils
 *
 * @since 1.2.0
 */
public final class Integers {

    /** private constructor for utility class */
    private Integers() {
    }

    public static Integer tryParse(String text, Integer def) {
        if (text == null) {
            return def;
        }
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return def;
        }
    }

    public static Integer tryParse(String text) {
        return tryParse(text, null);
    }

    public static boolean isZero(int v) {
        return v == 0;
    }

    public static int zero(int v) {
        if (isZero(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected int to equal 0 but got " + v);
    }

    public static boolean isPositive(int v) {
        return v > 0;
    }

    public static int positive(int v) {
        if (isPositive(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected int to be positive but got " + v);
    }

    public static boolean isNegative(int v) {
        return v < 0;
    }

    public static int negative(int v) {
        if (isNegative(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected int to be negative but got " + v);
    }

    public static boolean isZeroOrPositive(int v) {
        return v >= 0;
    }

    public static int zeroOrPositive(int v) {
        if (isZeroOrPositive(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected int to be zero or positive but got " + v);
    }

    public static boolean isZeroOrNegative(int v) {
        return v <= 0;
    }

    public static int zeroOrNegative(int v) {
        if (isZeroOrNegative(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected int to be zero or negative but got " + v);
    }

    public static boolean isInRangeInclusive(int v, int lo, int hi) {
        return v >= lo && v <= hi;
    }

    public static int inRangeInclusive(int v, int lo, int hi) {
        if (isInRangeInclusive(v, lo, hi)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " inclusive");
    }

    public static boolean isInRangeExclusive(int v, int lo, int hi) {
        return v > lo && v < hi;
    }

    public static int inRangeExclusive(int v, int lo, int hi) {
        if (isInRangeExclusive(v, lo, hi)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " exclusive");
    }

    public static boolean isEqual(int exp, int act) {
        return exp == act;
    }

    public static int equal(int exp, int act) {
        if (isEqual(exp, act)) {
            return act;
        }
        throw new IllegalArgumentException("Expected " + act + " to equal to " + exp);
    }

    public static boolean isGreater(int v, int lo) {
        return v > lo;
    }

    public static int greater(int v, int lo) {
        if (isGreater(v, lo)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be greater than " + lo);
    }

    public static boolean isGreaterOrEqual(int v, int lo) {
        return v >= lo;
    }

    public static int greaterOrEqual(int v, int lo) {
        if (isGreaterOrEqual(v, lo)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be greater or equal to " + lo);
    }

    public static boolean isSmaller(int v, int hi) {
        return v < hi;
    }

    public static int smaller(int v, int hi) {
        if (isSmaller(v, hi)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be smaller than " + hi);
    }

    public static boolean isSmallerOrEqual(int v, int hi) {
        return v <= hi;
    }

    public static int smallerOrEqual(int v, int hi) {
        if (isSmallerOrEqual(v, hi)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be smaller or equal to " + hi);
    }

    public static int limit(int v, int lo, int hi) {
        if (v < lo) {
            return lo;
        }
        return Math.min(v, hi);
    }
}
