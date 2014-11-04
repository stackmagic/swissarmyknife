// Copyright (C) Layzapp AG. All Rights Reserved.
package net.swisstech.swissarmyknife.lang;

/** some number utils */
public final class Longs {

	/** private constructor for utility class */
	private Longs() {}

	public static long zero(long l) {
		if (l != 0) {
			throw new IllegalArgumentException("Expected long to equal 0 but got " + l);
		}
		return l;
	}

	public static long positive(long l) {
		if (l <= 0) {
			throw new IllegalArgumentException("Expected long to be positive but got " + l);
		}
		return l;
	}

	public static long negative(long l) {
		if (l >= 0) {
			throw new IllegalArgumentException("Expected long to be negative but got " + l);
		}
		return l;
	}

	public static long zeroOrPositive(long l) {
		if (l < 0) {
			throw new IllegalArgumentException("Expected long to be zero or positive but got " + l);
		}
		return l;
	}

	public static long zeroOrNegative(long l) {
		if (l > 0) {
			throw new IllegalArgumentException("Expected long to be zero or negative but got " + l);
		}
		return l;
	}
}
