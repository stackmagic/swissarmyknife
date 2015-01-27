package net.swisstech.swissarmyknife.lang;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

//TODO structurally exactly the same as Longs, Integers, Integers, Shorts etc... have 1 master and generate the rest!!

/**
 * some long number utils
 * @since 1.2.0
 */
public class LongsTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Longs.class);
	}

	@Test
	public void isZero() {
		assertFalse(Longs.isZero(1));
		assertFalse(Longs.isZero(-1));
		assertTrue(Longs.isZero(0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroHi() {
		Longs.zero(1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroLo() {
		Longs.zero(-1);
	}

	@Test
	public void zero() {
		assertEquals(Longs.zero(0), 0);
	}

	@Test
	public void isPositive() {
		assertFalse(Longs.isPositive(0));
		assertTrue(Longs.isPositive(1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void positiveLo() {
		Longs.positive(0);
	}

	@Test
	public void positive() {
		assertEquals(Longs.positive(1), 1);
	}

	@Test
	public void isNegative() {
		assertFalse(Longs.isNegative(0));
		assertTrue(Longs.isNegative(-1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void negativeHi() {
		Longs.negative(0);
	}

	@Test
	public void negative() {
		assertEquals(Longs.negative(-1), -1);
	}

	@Test
	public void isZeroOrPositive() {
		assertFalse(Longs.isZeroOrPositive(-1));
		assertTrue(Longs.isZeroOrPositive(0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrpositiveLo() {
		Longs.zeroOrPositive(-1);
	}

	@Test
	public void zeroOrpositive() {
		assertEquals(Longs.zeroOrPositive(0), 0);
		assertEquals(Longs.zeroOrPositive(1), 1);
	}

	@Test
	public void iszeroOrNegative() {
		assertFalse(Longs.isZeroOrNegative(1));
		assertTrue(Longs.isZeroOrNegative(0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrNegativeHi() {
		Longs.zeroOrNegative(1);
	}

	@Test
	public void zeroOrNegative() {
		assertEquals(Longs.zeroOrNegative(0), 0);
		assertEquals(Longs.zeroOrNegative(-1), -1);
	}

	@Test
	public void isInRangeInclusive() {
		assertTrue(Longs.isInRangeInclusive(0, 0, 0));

		assertTrue(Longs.isInRangeInclusive(-1, -1, 1));
		assertTrue(Longs.isInRangeInclusive(0, -1, 1));
		assertTrue(Longs.isInRangeInclusive(1, -1, 1));

		assertFalse(Longs.isInRangeInclusive(-1, 0, 1));
		assertFalse(Longs.isInRangeInclusive(1, -1, 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveHi() {
		Longs.inRangeInclusive(1, -1, 0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveLo() {
		Longs.inRangeInclusive(-1, 0, 1);
	}

	@Test
	public void inRangeInclusive() {
		assertEquals(Longs.inRangeInclusive(0, 0, 0), 0);
	}

	@Test
	public void isInRangeExclusive() {
		assertFalse(Longs.isInRangeExclusive(0, 0, 0));
		assertFalse(Longs.isInRangeExclusive(0, -1, 0));
		assertFalse(Longs.isInRangeExclusive(0, 0, 1));

		assertTrue(Longs.isInRangeExclusive(0, -1, 1));
		assertTrue(Longs.isInRangeExclusive(-1, -2, 0));
		assertTrue(Longs.isInRangeExclusive(1, 0, 2));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveHi() {
		Longs.inRangeExclusive(1, -1, 1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveLo() {
		Longs.inRangeExclusive(-1, -1, 1);
	}

	@Test
	public void inRangeExclusive() {
		assertEquals(Longs.inRangeExclusive(0, -1, 1), 0);
	}

	@Test
	public void isEqual() {
		assertFalse(Longs.isEqual(0, 1));
		assertFalse(Longs.isEqual(1, 0));

		assertTrue(Longs.isEqual(0, 0));
		assertTrue(Longs.isEqual(1, 1));
		assertTrue(Longs.isEqual(-1, -1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void equalFalse() {
		Longs.equal(0, 1);
	}

	@Test
	public void equal() {
		assertEquals(Longs.equal(0, 0), 0);
	}

	@Test
	public void isGreater() {
		assertTrue(Longs.isGreater(1, 0));
		assertFalse(Longs.isGreater(1, 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterLo() {
		Longs.greater(1, 1);
	}

	@Test
	public void greater() {
		assertEquals(Longs.greater(1, 0), 1);
	}

	@Test
	public void isGreaterOrEqual() {
		assertFalse(Longs.isGreaterOrEqual(0, 1));
		assertTrue(Longs.isGreaterOrEqual(1, 1));
		assertTrue(Longs.isGreaterOrEqual(2, 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterOrEqualLo() {
		Longs.greaterOrEqual(0, 1);
	}

	@Test
	public void greaterOrEqual() {
		assertEquals(Longs.greaterOrEqual(1, 1), 1);
		assertEquals(Longs.greaterOrEqual(2, 1), 2);
	}

	@Test
	public void isSmaller() {
		assertFalse(Longs.isSmaller(1, 1));
		assertTrue(Longs.isSmaller(0, 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerHi() {
		Longs.smaller(1, 1);
	}

	@Test
	public void smaller() {
		assertEquals(Longs.smaller(0, 1), 0);
	}

	@Test
	public void isSmallerOrEqual() {
		assertFalse(Longs.isSmallerOrEqual(1, 0));
		assertTrue(Longs.isSmallerOrEqual(0, 0));
		assertTrue(Longs.isSmallerOrEqual(-1, 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerOrEqualHi() {
		Longs.smallerOrEqual(1, 0);
	}

	@Test
	public void smallerOrEqual() {
		assertEquals(Longs.smallerOrEqual(0, 0), 0);
		assertEquals(Longs.smallerOrEqual(-1, 0), -1);
	}
}
