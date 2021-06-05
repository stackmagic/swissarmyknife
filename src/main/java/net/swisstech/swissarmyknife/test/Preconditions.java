package net.swisstech.swissarmyknife.test;

import net.swisstech.swissarmyknife.lang.Strings;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

/**
 * Utility class to ensure certain preconditions. Each method will check and throw and {@link IllegalArgumentException} if the conditions are not met. This
 * class is intended for 'live' code. For unit tests use {@link Assert}
 *
 * @since 1.1.4
 */
public final class Preconditions {

    private static final String EXPECTED = "expected ";
    private static final String BUT_GOT = " but got ";

    /** private constructor for utility class */
    private Preconditions() {
    }

    public static <C> Class<C> interfacee(Class<C> c) {
        return ensureInterface(c, "must be an interface");
    }

    public static <C> Class<C> ensureInterface(Class<C> c, String msg) {
        if (!c.isInterface()) {
            throw new IllegalArgumentException(msg);
        }
        return c;
    }

    public static <O> O nulll(O o) {
        return ensureNull(o, "must be null");
    }

    public static <O> O ensureNull(O o, String msg) {
        if (o != null) {
            throw new IllegalArgumentException(msg);
        }
        return o;
    }

    public static <O> O notNull(O o) {
        return ensureNotNull(o, "must not be null");
    }

    public static <O> O ensureNotNull(O o, String msg) {
        if (o == null) {
            throw new IllegalArgumentException(msg);
        }
        return o;
    }

    public static boolean truee(boolean b) {
        return ensureTrue(b, "must be true");
    }

    public static boolean ensureTrue(boolean b, String msg) {
        if (!b) {
            throw new IllegalArgumentException(msg);
        }
        return b;
    }

    public static boolean falsee(boolean b) {
        return ensureFalse(b, "must be false");
    }

    public static boolean ensureFalse(boolean b, String msg) {
        if (b) {
            throw new IllegalArgumentException(msg);
        }
        return b;
    }

    public static void ensureEquals(byte actual, byte expected, String msg) {
        if (actual != expected) {
            throw new IllegalArgumentException(EXPECTED + expected + BUT_GOT + actual + ": " + msg);
        }
    }

    public static void ensureEquals(short actual, short expected, String msg) {
        if (actual != expected) {
            throw new IllegalArgumentException(EXPECTED + expected + BUT_GOT + actual + ": " + msg);
        }
    }

    public static void ensureEquals(int actual, int expected, String msg) {
        if (actual != expected) {
            throw new IllegalArgumentException(EXPECTED + expected + BUT_GOT + actual + ": " + msg);
        }
    }

    public static void ensureEquals(long actual, long expected, String msg) {
        if (actual != expected) {
            throw new IllegalArgumentException(EXPECTED + expected + BUT_GOT + actual + ": " + msg);
        }
    }

    public static void ensureEquals(float actual, float expected, String msg) {
        if (actual != expected) {
            throw new IllegalArgumentException(EXPECTED + expected + BUT_GOT + actual + ": " + msg);
        }
    }

    public static void ensureEquals(double actual, double expected, String msg) {
        if (actual != expected) {
            throw new IllegalArgumentException(EXPECTED + expected + BUT_GOT + actual + ": " + msg);
        }
    }

    public static void ensureEquals(char actual, char expected, String msg) {
        if (actual != expected) {
            throw new IllegalArgumentException(EXPECTED + expected + BUT_GOT + actual + ": " + msg);
        }
    }

    public static void ensureEquals(boolean actual, boolean expected, String msg) {
        if (actual != expected) {
            throw new IllegalArgumentException(EXPECTED + expected + BUT_GOT + actual + ": " + msg);
        }
    }

    public static void ensureEquals(Object actual, Object expected, String msg) {
        if (!actual.equals(expected)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void ensureLowerThanOrEqual(long value, long threshold, String msg) {
        if (!(value <= threshold)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void ensureLowerThan(long value, long threshold, String msg) {
        if (!(value < threshold)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void ensureHigherThan(long value, long threshold, String msg) {
        if (!(value > threshold)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void ensureHigherThanOrEqual(long value, long threshold, String msg) {
        if (!(value >= threshold)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void ensureHigherThanOrEqual(double value, double threshold, String msg) {
        if (!(value >= threshold)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void ensureLowerThanOrEqual(double value, double threshold, String msg) {
        if (!(value <= threshold)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void ensureLowerThan(double value, double threshold, String msg) {
        if (!(value < threshold)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void ensureHigherThan(double value, double threshold, String msg) {
        if (!(value > threshold)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void ensureBetweenIncluding(long lo, long hi, long value, String msg) {
        if (value < lo || value > hi) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void ensureNotEmpty(Collection<?> c, String msg) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void ensureEmpty(Collection<?> c, String msg) {
        if (!c.isEmpty()) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void ensureSize(Collection<?> c, int expectedSize, String msg) {
        if (expectedSize != c.size()) {
            throw new IllegalArgumentException("expected size was " + expectedSize + " but actual size was " + c.size() + ": " + msg);
        }
    }

    public static URL ensureUrl(String url) {
        try {
            return new URL(Strings.notBlank(url));
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("could not parse url from '" + url + "'", e);
        }
    }
}
