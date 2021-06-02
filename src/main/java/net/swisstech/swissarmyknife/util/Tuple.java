package net.swisstech.swissarmyknife.util;

/**
 * Immutable Tuple
 *
 * @since 2.1.0
 */
public final class Tuple<A, B> {

    public final A a;
    public final B b;

    public Tuple(A a, B b) {
        this.a = a;
        this.b = b;
    }
}