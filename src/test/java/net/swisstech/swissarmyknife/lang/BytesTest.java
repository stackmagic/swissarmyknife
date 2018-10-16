package net.swisstech.swissarmyknife.lang;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

//TODO structurally exactly the same as Longs, Bytes, Integers, Shorts etc... have 1 master and generate the rest!!

/**
 * some byte number utils
 *
 * @since 1.2.0
 */
public class BytesTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Bytes.class);
	}

	@Test
	public void isZero() {
		assertFalse(Bytes.isZero((byte) 1));
		assertFalse(Bytes.isZero((byte) -1));
		assertTrue(Bytes.isZero((byte) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroHi() {
		Bytes.zero((byte) 1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroLo() {
		Bytes.zero((byte) -1);
	}

	@Test
	public void zero() {
		assertEquals(Bytes.zero((byte) 0), (byte) 0);
	}

	@Test
	public void isPositive() {
		assertFalse(Bytes.isPositive((byte) 0));
		assertTrue(Bytes.isPositive((byte) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void positiveLo() {
		Bytes.positive((byte) 0);
	}

	@Test
	public void positive() {
		assertEquals(Bytes.positive((byte) 1), (byte) 1);
	}

	@Test
	public void isNegative() {
		assertFalse(Bytes.isNegative((byte) 0));
		assertTrue(Bytes.isNegative((byte) -1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void negativeHi() {
		Bytes.negative((byte) 0);
	}

	@Test
	public void negative() {
		assertEquals(Bytes.negative((byte) -1), (byte) -1);
	}

	@Test
	public void isZeroOrPositive() {
		assertFalse(Bytes.isZeroOrPositive((byte) -1));
		assertTrue(Bytes.isZeroOrPositive((byte) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrpositiveLo() {
		Bytes.zeroOrPositive((byte) -1);
	}

	@Test
	public void zeroOrpositive() {
		assertEquals(Bytes.zeroOrPositive((byte) 0), (byte) 0);
		assertEquals(Bytes.zeroOrPositive((byte) 1), (byte) 1);
	}

	@Test
	public void iszeroOrNegative() {
		assertFalse(Bytes.isZeroOrNegative((byte) 1));
		assertTrue(Bytes.isZeroOrNegative((byte) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrNegativeHi() {
		Bytes.zeroOrNegative((byte) 1);
	}

	@Test
	public void zeroOrNegative() {
		assertEquals(Bytes.zeroOrNegative((byte) 0), (byte) 0);
		assertEquals(Bytes.zeroOrNegative((byte) -1), (byte) -1);
	}

	@Test
	public void isInRangeInclusive() {
		assertTrue(Bytes.isInRangeInclusive((byte) 0, (byte) 0, (byte) 0));

		assertTrue(Bytes.isInRangeInclusive((byte) -1, (byte) -1, (byte) 1));
		assertTrue(Bytes.isInRangeInclusive((byte) 0, (byte) -1, (byte) 1));
		assertTrue(Bytes.isInRangeInclusive((byte) 1, (byte) -1, (byte) 1));

		assertFalse(Bytes.isInRangeInclusive((byte) -1, (byte) 0, (byte) 1));
		assertFalse(Bytes.isInRangeInclusive((byte) 1, (byte) -1, (byte) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveHi() {
		Bytes.inRangeInclusive((byte) 1, (byte) -1, (byte) 0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveLo() {
		Bytes.inRangeInclusive((byte) -1, (byte) 0, (byte) 1);
	}

	@Test
	public void inRangeInclusive() {
		assertEquals(Bytes.inRangeInclusive((byte) 0, (byte) 0, (byte) 0), (byte) 0);
	}

	@Test
	public void isInRangeExclusive() {
		assertFalse(Bytes.isInRangeExclusive((byte) 0, (byte) 0, (byte) 0));
		assertFalse(Bytes.isInRangeExclusive((byte) 0, (byte) -1, (byte) 0));
		assertFalse(Bytes.isInRangeExclusive((byte) 0, (byte) 0, (byte) 1));

		assertTrue(Bytes.isInRangeExclusive((byte) 0, (byte) -1, (byte) 1));
		assertTrue(Bytes.isInRangeExclusive((byte) -1, (byte) -2, (byte) 0));
		assertTrue(Bytes.isInRangeExclusive((byte) 1, (byte) 0, (byte) 2));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveHi() {
		Bytes.inRangeExclusive((byte) 1, (byte) -1, (byte) 1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveLo() {
		Bytes.inRangeExclusive((byte) -1, (byte) -1, (byte) 1);
	}

	@Test
	public void inRangeExclusive() {
		assertEquals(Bytes.inRangeExclusive((byte) 0, (byte) -1, (byte) 1), (byte) 0);
	}

	@Test
	public void isEqual() {
		assertFalse(Bytes.isEqual((byte) 0, (byte) 1));
		assertFalse(Bytes.isEqual((byte) 1, (byte) 0));

		assertTrue(Bytes.isEqual((byte) 0, (byte) 0));
		assertTrue(Bytes.isEqual((byte) 1, (byte) 1));
		assertTrue(Bytes.isEqual((byte) -1, (byte) -1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void equalFalse() {
		Bytes.equal((byte) 0, (byte) 1);
	}

	@Test
	public void equal() {
		assertEquals(Bytes.equal((byte) 0, (byte) 0), (byte) 0);
	}

	@Test
	public void isGreater() {
		assertTrue(Bytes.isGreater((byte) 1, (byte) 0));
		assertFalse(Bytes.isGreater((byte) 1, (byte) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterLo() {
		Bytes.greater((byte) 1, (byte) 1);
	}

	@Test
	public void greater() {
		assertEquals(Bytes.greater((byte) 1, (byte) 0), (byte) 1);
	}

	@Test
	public void isGreaterOrEqual() {
		assertFalse(Bytes.isGreaterOrEqual((byte) 0, (byte) 1));
		assertTrue(Bytes.isGreaterOrEqual((byte) 1, (byte) 1));
		assertTrue(Bytes.isGreaterOrEqual((byte) 2, (byte) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterOrEqualLo() {
		Bytes.greaterOrEqual((byte) 0, (byte) 1);
	}

	@Test
	public void greaterOrEqual() {
		assertEquals(Bytes.greaterOrEqual((byte) 1, (byte) 1), (byte) 1);
		assertEquals(Bytes.greaterOrEqual((byte) 2, (byte) 1), (byte) 2);
	}

	@Test
	public void isSmaller() {
		assertFalse(Bytes.isSmaller((byte) 1, (byte) 1));
		assertTrue(Bytes.isSmaller((byte) 0, (byte) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerHi() {
		Bytes.smaller((byte) 1, (byte) 1);
	}

	@Test
	public void smaller() {
		assertEquals(Bytes.smaller((byte) 0, (byte) 1), (byte) 0);
	}

	@Test
	public void isSmallerOrEqual() {
		assertFalse(Bytes.isSmallerOrEqual((byte) 1, (byte) 0));
		assertTrue(Bytes.isSmallerOrEqual((byte) 0, (byte) 0));
		assertTrue(Bytes.isSmallerOrEqual((byte) -1, (byte) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerOrEqualHi() {
		Bytes.smallerOrEqual((byte) 1, (byte) 0);
	}

	@Test
	public void smallerOrEqual() {
		assertEquals(Bytes.smallerOrEqual((byte) 0, (byte) 0), (byte) 0);
		assertEquals(Bytes.smallerOrEqual((byte) -1, (byte) 0), (byte) -1);
	}

	@Test
	public void limit() {
		assertEquals(Bytes.limit((byte) 0, (byte) 0, (byte) 0), (byte) 0);
		assertEquals(Bytes.limit((byte) 5, (byte) 0, (byte) 0), (byte) 0);

		assertEquals(Bytes.limit((byte) 5, (byte) 5, (byte) 10), (byte) 5);
		assertEquals(Bytes.limit((byte) 0, (byte) 5, (byte) 10), (byte) 5);

		assertEquals(Bytes.limit((byte) 5, (byte) 0, (byte) 5), (byte) 5);
		assertEquals(Bytes.limit((byte) 10, (byte) 0, (byte) 5), (byte) 5);
	}
}
