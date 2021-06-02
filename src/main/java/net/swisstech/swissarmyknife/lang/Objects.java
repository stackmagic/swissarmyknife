package net.swisstech.swissarmyknife.lang;

public final class Objects {

    /** private constructor for utility class */
    private Objects() {}

    public static <T> T notNull(T o) {
        return notNull(o, "");
    }

    /** @since 2.1.0 */
    public static <T> T notNull(T o, String name) {
        if (o == null) {
            throw new IllegalArgumentException("Object '" + name + "' must not be null");
        }
        return o;
    }

    /** @since 2.1.0 */
    public static <T> T valueOrDefault(T value, T dflt) {
        if (value == null) {
            return dflt;
        }
        return value;
    }
}
