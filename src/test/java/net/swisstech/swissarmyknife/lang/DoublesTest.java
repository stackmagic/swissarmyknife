package net.swisstech.swissarmyknife.lang;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

//TODO structurally exactly the same as Longs, Integers, Integers, Shorts etc... have 1 master and generate the rest!!

/**
 * @since 1.2.0
 */
public class DoublesTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Doubles.class);
	}

	@Test
	public void tryParseDouble() {
		assertNull(Doubles.tryParse("null"));
		assertEquals((double) Doubles.tryParse("1.2"), 1.2);
		assertEquals((double) Doubles.tryParse("1.2", 23.4), 1.2);
		assertEquals((double) Doubles.tryParse("1 3 4", 23.4), 23.4);
		assertEquals((double) Doubles.tryParse(null, 23.4), 23.4);
	}

	@Test
	public void isZero() {
		assertFalse(Doubles.isZero(1.0));
		assertFalse(Doubles.isZero(-1.0));
		assertTrue(Doubles.isZero(0.0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroHi() {
		Doubles.zero(1.0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroLo() {
		Doubles.zero(-1.0);
	}

	@Test
	public void zero() {
		assertEquals(Doubles.zero(0.0), 0.0);
	}

	@Test
	public void isPositive() {
		assertFalse(Doubles.isPositive(0.0));
		assertTrue(Doubles.isPositive(1.0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void positiveLo() {
		Doubles.positive(0.0);
	}

	@Test
	public void positive() {
		assertEquals(Doubles.positive(1.0), 1.0);
	}

	@Test
	public void isNegative() {
		assertFalse(Doubles.isNegative(0.0));
		assertTrue(Doubles.isNegative(-1.0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void negativeHi() {
		Doubles.negative(0.0);
	}

	@Test
	public void negative() {
		assertEquals(Doubles.negative(-1.0), -1.0);
	}

	@Test
	public void isZeroOrPositive() {
		assertFalse(Doubles.isZeroOrPositive(-1.0));
		assertTrue(Doubles.isZeroOrPositive(0.0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrPositiveLo() {
		Doubles.zeroOrPositive(-1.0);
	}

	@Test
	public void zeroOrPositive() {
		assertEquals(Doubles.zeroOrPositive(0.0), 0.0);
		assertEquals(Doubles.zeroOrPositive(1.0), 1.0);
	}

	@Test
	public void isZeroOrNegative() {
		assertFalse(Doubles.isZeroOrNegative(1.0));
		assertTrue(Doubles.isZeroOrNegative(0.0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrNegativeHi() {
		Doubles.zeroOrNegative(1.0);
	}

	@Test
	public void zeroOrNegative() {
		assertEquals(Doubles.zeroOrNegative(0.0), 0.0);
		assertEquals(Doubles.zeroOrNegative(-1.0), -1.0);
	}

	@Test
	public void isInRangeInclusive() {
		assertTrue(Doubles.isInRangeInclusive(0.0, 0.0, 0.0));

		assertTrue(Doubles.isInRangeInclusive(-1.0, -1.0, 1.0));
		assertTrue(Doubles.isInRangeInclusive(0.0, -1.0, 1.0));
		assertTrue(Doubles.isInRangeInclusive(1.0, -1.0, 1.0));

		assertFalse(Doubles.isInRangeInclusive(-1.0, 0.0, 1.0));
		assertFalse(Doubles.isInRangeInclusive(1.0, -1.0, 0.0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveHi() {
		Doubles.inRangeInclusive(1.0, -1.0, 0.0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveLo() {
		Doubles.inRangeInclusive(-1.0, 0.0, 1.0);
	}

	@Test
	public void inRangeInclusive() {
		assertEquals(Doubles.inRangeInclusive(0.0, 0.0, 0.0), 0.0);
	}

	@Test
	public void isInRangeExclusive() {
		assertFalse(Doubles.isInRangeExclusive(0.0, 0.0, 0.0));
		assertFalse(Doubles.isInRangeExclusive(0.0, -1.0, 0.0));
		assertFalse(Doubles.isInRangeExclusive(0.0, 0.0, 1.0));

		assertTrue(Doubles.isInRangeExclusive(0.0, -1.0, 1.0));
		assertTrue(Doubles.isInRangeExclusive(-1.0, -2.0, 0.0));
		assertTrue(Doubles.isInRangeExclusive(1.0, 0.0, 2.0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveHi() {
		Doubles.inRangeExclusive(1.0, -1.0, 1.0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveLo() {
		Doubles.inRangeExclusive(-1.0, -1.0, 1.0);
	}

	@Test
	public void inRangeExclusive() {
		assertEquals(Doubles.inRangeExclusive(0.0, -1.0, 1.0), 0.0);
	}

	@Test
	public void isEqual() {
		assertFalse(Doubles.isEqual(0.0, 1.0));
		assertFalse(Doubles.isEqual(1.0, 0.0));

		assertTrue(Doubles.isEqual(0.0, 0.0));
		assertTrue(Doubles.isEqual(1.0, 1.0));
		assertTrue(Doubles.isEqual(-1.0, -1.0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void equalFalse() {
		Doubles.equal(0, 1);
	}

	@Test
	public void equal() {
		assertEquals(Doubles.equal(0.0, 0.0), 0.0);
	}

	@Test
	public void isGreater() {
		assertTrue(Doubles.isGreater(1.0, 0.0));
		assertFalse(Doubles.isGreater(1.0, 1.0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterLo() {
		Doubles.greater(1.0, 1.0);
	}

	@Test
	public void greater() {
		assertEquals(Doubles.greater(1.0, 0.0), 1.0);
	}

	@Test
	public void isGreaterOrEqual() {
		assertFalse(Doubles.isGreaterOrEqual(0.0, 1.0));
		assertTrue(Doubles.isGreaterOrEqual(1.0, 1.0));
		assertTrue(Doubles.isGreaterOrEqual(2.0, 1.0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterOrEqualLo() {
		Doubles.greaterOrEqual(0, 1);
	}

	@Test
	public void greaterOrEqual() {
		assertEquals(Doubles.greaterOrEqual(1.0, 1.0), 1.0);
		assertEquals(Doubles.greaterOrEqual(2.0, 1.0), 2.0);
	}

	@Test
	public void isSmaller() {
		assertFalse(Doubles.isSmaller(1.0, 1.0));
		assertTrue(Doubles.isSmaller(0.0, 1.0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerHi() {
		Doubles.smaller(1.0, 1.0);
	}

	@Test
	public void smaller() {
		assertEquals(Doubles.smaller(0.0, 1.0), 0.0);
	}

	@Test
	public void isSmallerOrEqual() {
		assertFalse(Doubles.isSmallerOrEqual(1.0, 0.0));
		assertTrue(Doubles.isSmallerOrEqual(0.0, 0.0));
		assertTrue(Doubles.isSmallerOrEqual(-1.0, 0.0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerOrEqualHi() {
		Doubles.smallerOrEqual(1.0, 0.0);
	}

	@Test
	public void smallerOrEqual() {
		assertEquals(Doubles.smallerOrEqual(0.0, 0.0), 0.0);
		assertEquals(Doubles.smallerOrEqual(-1.0, 0.0), -1.0);
	}

	@Test
	public void limit() {
		assertEquals(Doubles.limit(0.0, 0.0, 0.0), 0.0);
		assertEquals(Doubles.limit(5.0, 0.0, 0.0), 0.0);

		assertEquals(Doubles.limit(5.0, 5.0, 10.0), 5.0);
		assertEquals(Doubles.limit(0.0, 5.0, 10.0), 5.0);

		assertEquals(Doubles.limit(5.0, 0.0, 5.0), 5.0);
		assertEquals(Doubles.limit(10.0, 0.0, 5.0), 5.0);
	}
}
