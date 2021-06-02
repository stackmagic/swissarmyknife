package net.swisstech.swissarmyknife.util;

import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;

/**
 * {@link java.security.SecureRandom} with added features
 */
public class Randoms extends SecureRandom {

    public Randoms() {
        super();
    }

    public Randoms(byte[] bytes) {
        super(bytes);
    }

    protected Randoms(SecureRandomSpi secureRandomSpi, Provider provider) {
        super(secureRandomSpi, provider);
    }

    public int nextIntInclusive(int lo, int hi) {
        // nextInt(bound) returns 0..bound
        return lo + nextInt(hi - lo);
    }

    public long nextLongInclusive(long lo, long hi) {
        // nextLong returns Long.MIN_VALUE..Long.MAX_VALUE
        long range = hi - lo;
        long random = nextLong();
        long modulo = Math.abs(random % range);
        return lo + modulo;
    }

    public double nextDoubleInclusive(double lo, double hi) {
        // nextDouble returns 0..1
        return lo + nextDouble() * (hi - lo);
    }

    public float nextFloatInclusive(float lo, float hi) {
        // nextFloat returns 0..1
        return lo + nextFloat() * (hi - lo);
    }
}
