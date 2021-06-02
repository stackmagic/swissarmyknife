package net.swisstech.swissarmyknife.util;

/**
 * Immutable Triple
 *
 * @since 2.1.0
 */
public final class Triple<A, B, C> {

    public final A a;
    public final B b;
    public final C c;

    public Triple(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}