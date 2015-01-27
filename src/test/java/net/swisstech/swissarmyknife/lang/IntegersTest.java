package net.swisstech.swissarmyknife.lang;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

//TODO structurally exactly the same as Longs, Integers, Integers, Shorts etc... have 1 master and generate the rest!!

/**
 * some int number utils
 * @since 1.2.0
 */
public class IntegersTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Integers.class);
	}

	@Test
	public void isZero() {
		assertFalse(Integers.isZero(1));
		assertFalse(Integers.isZero(-1));
		assertTrue(Integers.isZero(0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroHi() {
		Integers.zero(1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroLo() {
		Integers.zero(-1);
	}

	@Test
	public void zero() {
		assertEquals(Integers.zero(0), 0);
	}

	@Test
	public void isPositive() {
		assertFalse(Integers.isPositive(0));
		assertTrue(Integers.isPositive(1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void positiveLo() {
		Integers.positive(0);
	}

	@Test
	public void positive() {
		assertEquals(Integers.positive(1), 1);
	}

	@Test
	public void isNegative() {
		assertFalse(Integers.isNegative(0));
		assertTrue(Integers.isNegative(-1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void negativeHi() {
		Integers.negative(0);
	}

	@Test
	public void negative() {
		assertEquals(Integers.negative(-1), -1);
	}

	@Test
	public void isZeroOrPositive() {
		assertFalse(Integers.isZeroOrPositive(-1));
		assertTrue(Integers.isZeroOrPositive(0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrpositiveLo() {
		Integers.zeroOrPositive(-1);
	}

	@Test
	public void zeroOrpositive() {
		assertEquals(Integers.zeroOrPositive(0), 0);
		assertEquals(Integers.zeroOrPositive(1), 1);
	}

	@Test
	public void iszeroOrNegative() {
		assertFalse(Integers.isZeroOrNegative(1));
		assertTrue(Integers.isZeroOrNegative(0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrNegativeHi() {
		Integers.zeroOrNegative(1);
	}

	@Test
	public void zeroOrNegative() {
		assertEquals(Integers.zeroOrNegative(0), 0);
		assertEquals(Integers.zeroOrNegative(-1), -1);
	}

	@Test
	public void isInRangeInclusive() {
		assertTrue(Integers.isInRangeInclusive((int) 0, (int) 0, (int) 0));

		assertTrue(Integers.isInRangeInclusive((int) -1, (int) -1, (int) 1));
		assertTrue(Integers.isInRangeInclusive((int) 0, (int) -1, (int) 1));
		assertTrue(Integers.isInRangeInclusive((int) 1, (int) -1, (int) 1));

		assertFalse(Integers.isInRangeInclusive((int) -1, (int) 0, (int) 1));
		assertFalse(Integers.isInRangeInclusive((int) 1, (int) -1, (int) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveHi() {
		Integers.inRangeInclusive(1, -1, 0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveLo() {
		Integers.inRangeInclusive(-1, 0, 1);
	}

	@Test
	public void inRangeInclusive() {
		assertEquals(Integers.inRangeInclusive(0, 0, 0), 0);
	}

	@Test
	public void isInRangeExclusive() {
		assertFalse(Integers.isInRangeExclusive(0, 0, 0));
		assertFalse(Integers.isInRangeExclusive(0, -1, 0));
		assertFalse(Integers.isInRangeExclusive(0, 0, 1));

		assertTrue(Integers.isInRangeExclusive(0, -1, 1));
		assertTrue(Integers.isInRangeExclusive(-1, -2, 0));
		assertTrue(Integers.isInRangeExclusive(1, 0, 2));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveHi() {
		Integers.inRangeExclusive(1, -1, 1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveLo() {
		Integers.inRangeExclusive(-1, -1, 1);
	}

	@Test
	public void inRangeExclusive() {
		assertEquals(Integers.inRangeExclusive(0, -1, 1), 0);
	}

	@Test
	public void isEqual() {
		assertFalse(Integers.isEqual(0, 1));
		assertFalse(Integers.isEqual(1, 0));

		assertTrue(Integers.isEqual(0, 0));
		assertTrue(Integers.isEqual(1, 1));
		assertTrue(Integers.isEqual(-1, -1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void equalFalse() {
		Integers.equal(0, 1);
	}

	@Test
	public void equal() {
		assertEquals(Integers.equal(0, 0), 0);
	}

	@Test
	public void isGreater() {
		assertTrue(Integers.isGreater((int) 1, (int) 0));
		assertFalse(Integers.isGreater((int) 1, (int) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterLo() {
		Integers.greater((int) 1, (int) 1);
	}

	@Test
	public void greater() {
		assertEquals(Integers.greater((int) 1, (int) 0), (int) 1);
	}

	@Test
	public void isGreaterOrEqual() {
		assertFalse(Integers.isGreaterOrEqual((int) 0, (int) 1));
		assertTrue(Integers.isGreaterOrEqual((int) 1, (int) 1));
		assertTrue(Integers.isGreaterOrEqual((int) 2, (int) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterOrEqualLo() {
		Integers.greaterOrEqual((int) 0, (int) 1);
	}

	@Test
	public void greaterOrEqual() {
		assertEquals(Integers.greaterOrEqual((int) 1, (int) 1), (int) 1);
		assertEquals(Integers.greaterOrEqual((int) 2, (int) 1), (int) 2);
	}

	@Test
	public void isSmaller() {
		assertFalse(Integers.isSmaller((int) 1, (int) 1));
		assertTrue(Integers.isSmaller((int) 0, (int) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerHi() {
		Integers.smaller((int) 1, (int) 1);
	}

	@Test
	public void smaller() {
		assertEquals(Integers.smaller((int) 0, (int) 1), (int) 0);
	}

	@Test
	public void isSmallerOrEqual() {
		assertFalse(Integers.isSmallerOrEqual((int) 1, (int) 0));
		assertTrue(Integers.isSmallerOrEqual((int) 0, (int) 0));
		assertTrue(Integers.isSmallerOrEqual((int) -1, (int) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerOrEqualHi() {
		Integers.smallerOrEqual((int) 1, (int) 0);
	}

	@Test
	public void smallerOrEqual() {
		assertEquals(Integers.smallerOrEqual((int) 0, (int) 0), (int) 0);
		assertEquals(Integers.smallerOrEqual((int) -1, (int) 0), (int) -1);
	}

}
