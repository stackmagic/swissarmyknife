package net.swisstech.swissarmyknife.lang;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

//TODO structurally exactly the same as Longs, Integers, Integers, Shorts etc... have 1 master and generate the rest!!

/**
 * some short number utils
 *
 * @since 1.2.0
 */
public class ShortsTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Shorts.class);
	}

	@Test
	public void isZero() {
		assertFalse(Shorts.isZero((short) 1));
		assertFalse(Shorts.isZero((short) -1));
		assertTrue(Shorts.isZero((short) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroHi() {
		Shorts.zero((short) 1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroLo() {
		Shorts.zero((short) -1);
	}

	@Test
	public void zero() {
		assertEquals(Shorts.zero((short) 0), (short) 0);
	}

	@Test
	public void isPositive() {
		assertFalse(Shorts.isPositive((short) 0));
		assertTrue(Shorts.isPositive((short) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void positiveLo() {
		Shorts.positive((short) 0);
	}

	@Test
	public void positive() {
		assertEquals(Shorts.positive((short) 1), (short) 1);
	}

	@Test
	public void isNegative() {
		assertFalse(Shorts.isNegative((short) 0));
		assertTrue(Shorts.isNegative((short) -1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void negativeHi() {
		Shorts.negative((short) 0);
	}

	@Test
	public void negative() {
		assertEquals(Shorts.negative((short) -1), (short) -1);
	}

	@Test
	public void isZeroOrPositive() {
		assertFalse(Shorts.isZeroOrPositive((short) -1));
		assertTrue(Shorts.isZeroOrPositive((short) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrpositiveLo() {
		Shorts.zeroOrPositive((short) -1);
	}

	@Test
	public void zeroOrpositive() {
		assertEquals(Shorts.zeroOrPositive((short) 0), (short) 0);
		assertEquals(Shorts.zeroOrPositive((short) 1), (short) 1);
	}

	@Test
	public void iszeroOrNegative() {
		assertFalse(Shorts.isZeroOrNegative((short) 1));
		assertTrue(Shorts.isZeroOrNegative((short) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrNegativeHi() {
		Shorts.zeroOrNegative((short) 1);
	}

	@Test
	public void zeroOrNegative() {
		assertEquals(Shorts.zeroOrNegative((short) 0), (short) 0);
		assertEquals(Shorts.zeroOrNegative((short) -1), (short) -1);
	}

	@Test
	public void isInRangeInclusive() {
		assertTrue(Shorts.isInRangeInclusive((short) 0, (short) 0, (short) 0));

		assertTrue(Shorts.isInRangeInclusive((short) -1, (short) -1, (short) 1));
		assertTrue(Shorts.isInRangeInclusive((short) 0, (short) -1, (short) 1));
		assertTrue(Shorts.isInRangeInclusive((short) 1, (short) -1, (short) 1));

		assertFalse(Shorts.isInRangeInclusive((short) -1, (short) 0, (short) 1));
		assertFalse(Shorts.isInRangeInclusive((short) 1, (short) -1, (short) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveHi() {
		Shorts.inRangeInclusive((short) 1, (short) -1, (short) 0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveLo() {
		Shorts.inRangeInclusive((short) -1, (short) 0, (short) 1);
	}

	@Test
	public void inRangeInclusive() {
		assertEquals(Shorts.inRangeInclusive((short) 0, (short) 0, (short) 0), (short) 0);
	}

	@Test
	public void isInRangeExclusive() {
		assertFalse(Shorts.isInRangeExclusive((short) 0, (short) 0, (short) 0));
		assertFalse(Shorts.isInRangeExclusive((short) 0, (short) -1, (short) 0));
		assertFalse(Shorts.isInRangeExclusive((short) 0, (short) 0, (short) 1));

		assertTrue(Shorts.isInRangeExclusive((short) 0, (short) -1, (short) 1));
		assertTrue(Shorts.isInRangeExclusive((short) -1, (short) -2, (short) 0));
		assertTrue(Shorts.isInRangeExclusive((short) 1, (short) 0, (short) 2));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveHi() {
		Shorts.inRangeExclusive((short) 1, (short) -1, (short) 1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveLo() {
		Shorts.inRangeExclusive((short) -1, (short) -1, (short) 1);
	}

	@Test
	public void inRangeExclusive() {
		assertEquals(Shorts.inRangeExclusive((short) 0, (short) -1, (short) 1), (short) 0);
	}

	@Test
	public void isEqual() {
		assertFalse(Shorts.isEqual((short) 0, (short) 1));
		assertFalse(Shorts.isEqual((short) 1, (short) 0));

		assertTrue(Shorts.isEqual((short) 0, (short) 0));
		assertTrue(Shorts.isEqual((short) 1, (short) 1));
		assertTrue(Shorts.isEqual((short) -1, (short) -1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void equalFalse() {
		Shorts.equal((short) 0, (short) 1);
	}

	@Test
	public void equal() {
		assertEquals(Shorts.equal((short) 0, (short) 0), (short) 0);
	}

	@Test
	public void isGreater() {
		assertTrue(Shorts.isGreater((short) 1, (short) 0));
		assertFalse(Shorts.isGreater((short) 1, (short) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterLo() {
		Shorts.greater((short) 1, (short) 1);
	}

	@Test
	public void greater() {
		assertEquals(Shorts.greater((short) 1, (short) 0), (short) 1);
	}

	@Test
	public void isGreaterOrEqual() {
		assertFalse(Shorts.isGreaterOrEqual((short) 0, (short) 1));
		assertTrue(Shorts.isGreaterOrEqual((short) 1, (short) 1));
		assertTrue(Shorts.isGreaterOrEqual((short) 2, (short) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterOrEqualLo() {
		Shorts.greaterOrEqual((short) 0, (short) 1);
	}

	@Test
	public void greaterOrEqual() {
		assertEquals(Shorts.greaterOrEqual((short) 1, (short) 1), (short) 1);
		assertEquals(Shorts.greaterOrEqual((short) 2, (short) 1), (short) 2);
	}

	@Test
	public void isSmaller() {
		assertFalse(Shorts.isSmaller((short) 1, (short) 1));
		assertTrue(Shorts.isSmaller((short) 0, (short) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerHi() {
		Shorts.smaller((short) 1, (short) 1);
	}

	@Test
	public void smaller() {
		assertEquals(Shorts.smaller((short) 0, (short) 1), (short) 0);
	}

	@Test
	public void isSmallerOrEqual() {
		assertFalse(Shorts.isSmallerOrEqual((short) 1, (short) 0));
		assertTrue(Shorts.isSmallerOrEqual((short) 0, (short) 0));
		assertTrue(Shorts.isSmallerOrEqual((short) -1, (short) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerOrEqualHi() {
		Shorts.smallerOrEqual((short) 1, (short) 0);
	}

	@Test
	public void smallerOrEqual() {
		assertEquals(Shorts.smallerOrEqual((short) 0, (short) 0), (short) 0);
		assertEquals(Shorts.smallerOrEqual((short) -1, (short) 0), (short) -1);
	}

	@Test
	public void limit() {
		assertEquals(Shorts.limit((short) 0, (short) 0, (short) 0), (short) 0);
		assertEquals(Shorts.limit((short) 5, (short) 0, (short) 0), (short) 0);

		assertEquals(Shorts.limit((short) 5, (short) 5, (short) 10), (short) 5);
		assertEquals(Shorts.limit((short) 0, (short) 5, (short) 10), (short) 5);

		assertEquals(Shorts.limit((short) 5, (short) 0, (short) 5), (short) 5);
		assertEquals(Shorts.limit((short) 10, (short) 0, (short) 5), (short) 5);
	}
}
