// Copyright (C) Layzapp AG. All Rights Reserved.
package net.swisstech.swissarmyknife.lang;

import static net.swisstech.swissarmyknife.lang.Longs.negative;
import static net.swisstech.swissarmyknife.lang.Longs.positive;
import static net.swisstech.swissarmyknife.lang.Longs.zero;
import static net.swisstech.swissarmyknife.lang.Longs.zeroOrNegative;
import static net.swisstech.swissarmyknife.lang.Longs.zeroOrPositive;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

public class LongsTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Longs.class);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroNeg() {
		zero(-1);
	}

	@Test
	public void zeroOk() {
		assertEquals(zero(0), 0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroPos() {
		zero(1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void positiveNeg() {
		positive(-1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void positiveZero() {
		positive(0);
	}

	@Test
	public void positivePos() {
		assertEquals(positive(1), 1);
	}

	@Test
	public void negativeNeg() {
		assertEquals(negative(-1), -1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void negativeZero() {
		negative(0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void negativePos() {
		negative(1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrPositiveNeg() {
		zeroOrPositive(-1);
	}

	@Test
	public void zeroOrPositiveZero() {
		assertEquals(zeroOrPositive(0), 0);
	}

	@Test
	public void zeroOrPositivePos() {
		assertEquals(zeroOrPositive(1), 1);
	}

	@Test
	public void zeroOrNegativeNeg() {
		assertEquals(zeroOrNegative(-1), -1);
	}

	@Test
	public void zeroOrNegativeZero() {
		assertEquals(zeroOrNegative(0), 0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrNegativePos() {
		zeroOrNegative(1);
	}
}
