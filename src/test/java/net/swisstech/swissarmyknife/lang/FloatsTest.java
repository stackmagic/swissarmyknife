package net.swisstech.swissarmyknife.lang;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

//TODO structurally exactly the same as Longs, Integers, Integers, Shorts etc... have 1 master and generate the rest!!

/**
 * some long number utils
 *
 * @since 1.2.0
 */
public class FloatsTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Floats.class);
	}

	@Test
	public void tryParse() {
		assertNull(Floats.tryParse("null"));
		assertEquals(Floats.tryParse("1"), 1f);
		assertEquals(Floats.tryParse("1", 23.0f), 1f);
		assertEquals(Floats.tryParse("1 3 4", 23.0f), 23f);
		assertEquals(Floats.tryParse(null, 23.0f), 23f);
	}

	@Test
	public void isZero() {
		assertFalse(Floats.isZero(1.0f));
		assertFalse(Floats.isZero(-1.0f));
		assertTrue(Floats.isZero(0.0f));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroHi() {
		Floats.zero(1.0f);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroLo() {
		Floats.zero(-1.0f);
	}

	@Test
	public void zero() {
		assertEquals(Floats.zero(0.0f), 0.0f);
	}

	@Test
	public void isPositive() {
		assertFalse(Floats.isPositive(0.0f));
		assertTrue(Floats.isPositive(1.0f));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void positiveLo() {
		Floats.positive(0.0f);
	}

	@Test
	public void positive() {
		assertEquals(Floats.positive(1.0f), 1.0f);
	}

	@Test
	public void isNegative() {
		assertFalse(Floats.isNegative(0.0f));
		assertTrue(Floats.isNegative(-1.0f));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void negativeHi() {
		Floats.negative(0.0f);
	}

	@Test
	public void negative() {
		assertEquals(Floats.negative(-1.0f), -1.0f);
	}

	@Test
	public void isZeroOrPositive() {
		assertFalse(Floats.isZeroOrPositive(-1.0f));
		assertTrue(Floats.isZeroOrPositive(0.0f));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrpositiveLo() {
		Floats.zeroOrPositive(-1.0f);
	}

	@Test
	public void zeroOrpositive() {
		assertEquals(Floats.zeroOrPositive(0.0f), 0.0f);
		assertEquals(Floats.zeroOrPositive(1.0f), 1.0f);
	}

	@Test
	public void iszeroOrNegative() {
		assertFalse(Floats.isZeroOrNegative(1.0f));
		assertTrue(Floats.isZeroOrNegative(0.0f));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroOrNegativeHi() {
		Floats.zeroOrNegative(1.0f);
	}

	@Test
	public void zeroOrNegative() {
		assertEquals(Floats.zeroOrNegative(0.0f), 0.0f);
		assertEquals(Floats.zeroOrNegative(-1.0f), -1.0f);
	}

	@Test
	public void isInRangeInclusive() {
		assertTrue(Floats.isInRangeInclusive(0.0f, 0.0f, 0.0f));

		assertTrue(Floats.isInRangeInclusive(-1.0f, -1.0f, 1.0f));
		assertTrue(Floats.isInRangeInclusive(0.0f, -1.0f, 1.0f));
		assertTrue(Floats.isInRangeInclusive(1.0f, -1.0f, 1.0f));

		assertFalse(Floats.isInRangeInclusive(-1.0f, 0.0f, 1.0f));
		assertFalse(Floats.isInRangeInclusive(1.0f, -1.0f, 0.0f));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveHi() {
		Floats.inRangeInclusive(1.0f, -1.0f, 0.0f);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveLo() {
		Floats.inRangeInclusive(-1.0f, 0.0f, 1.0f);
	}

	@Test
	public void inRangeInclusive() {
		assertEquals(Floats.inRangeInclusive(0.0f, 0.0f, 0.0f), 0.0f);
	}

	@Test
	public void isInRangeExclusive() {
		assertFalse(Floats.isInRangeExclusive(0.0f, 0.0f, 0.0f));
		assertFalse(Floats.isInRangeExclusive(0.0f, -1.0f, 0.0f));
		assertFalse(Floats.isInRangeExclusive(0.0f, 0.0f, 1.0f));

		assertTrue(Floats.isInRangeExclusive(0.0f, -1.0f, 1.0f));
		assertTrue(Floats.isInRangeExclusive(-1.0f, -2.0f, 0.0f));
		assertTrue(Floats.isInRangeExclusive(1.0f, 0.0f, 2.0f));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveHi() {
		Floats.inRangeExclusive(1.0f, -1.0f, 1.0f);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveLo() {
		Floats.inRangeExclusive(-1.0f, -1.0f, 1.0f);
	}

	@Test
	public void inRangeExclusive() {
		assertEquals(Floats.inRangeExclusive(0.0f, -1.0f, 1.0f), 0.0f);
	}

	@Test
	public void isEqual() {
		assertFalse(Floats.isEqual(0.0f, 1.0f));
		assertFalse(Floats.isEqual(1.0f, 0.0f));

		assertTrue(Floats.isEqual(0.0f, 0.0f));
		assertTrue(Floats.isEqual(1.0f, 1.0f));
		assertTrue(Floats.isEqual(-1.0f, -1.0f));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void equalFalse() {
		Floats.equal(0, 1);
	}

	@Test
	public void equal() {
		assertEquals(Floats.equal(0.0f, 0.0f), 0.0f);
	}

	@Test
	public void isGreater() {
		assertTrue(Floats.isGreater(1.0f, 0.0f));
		assertFalse(Floats.isGreater(1.0f, 1.0f));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterLo() {
		Floats.greater(1.0f, 1.0f);
	}

	@Test
	public void greater() {
		assertEquals(Floats.greater(1.0f, 0.0f), 1.0f);
	}

	@Test
	public void isGreaterOrEqual() {
		assertFalse(Floats.isGreaterOrEqual(0.0f, 1.0f));
		assertTrue(Floats.isGreaterOrEqual(1.0f, 1.0f));
		assertTrue(Floats.isGreaterOrEqual(2.0f, 1.0f));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterOrEqualLo() {
		Floats.greaterOrEqual(0, 1);
	}

	@Test
	public void greaterOrEqual() {
		assertEquals(Floats.greaterOrEqual(1.0f, 1.0f), 1.0f);
		assertEquals(Floats.greaterOrEqual(2.0f, 1.0f), 2.0f);
	}

	@Test
	public void isSmaller() {
		assertFalse(Floats.isSmaller(1.0f, 1.0f));
		assertTrue(Floats.isSmaller(0.0f, 1.0f));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerHi() {
		Floats.smaller(1.0f, 1.0f);
	}

	@Test
	public void smaller() {
		assertEquals(Floats.smaller(0.0f, 1.0f), 0.0f);
	}

	@Test
	public void isSmallerOrEqual() {
		assertFalse(Floats.isSmallerOrEqual(1.0f, 0.0f));
		assertTrue(Floats.isSmallerOrEqual(0.0f, 0.0f));
		assertTrue(Floats.isSmallerOrEqual(-1.0f, 0.0f));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerOrEqualHi() {
		Floats.smallerOrEqual(1.0f, 0.0f);
	}

	@Test
	public void smallerOrEqual() {
		assertEquals(Floats.smallerOrEqual(0.0f, 0.0f), 0.0f);
		assertEquals(Floats.smallerOrEqual(-1.0f, 0.0f), -1.0f);
	}

	@Test
	public void limit() {
		assertEquals(Floats.limit(0.0f, 0.0f, 0.0f), 0.0f);
		assertEquals(Floats.limit(5.0f, 0.0f, 0.0f), 0.0f);

		assertEquals(Floats.limit(5.0f, 5.0f, 10.0f), 5.0f);
		assertEquals(Floats.limit(0.0f, 5.0f, 10.0f), 5.0f);

		assertEquals(Floats.limit(5.0f, 0.0f, 5.0f), 5.0f);
		assertEquals(Floats.limit(10.0f, 0.0f, 5.0f), 5.0f);
	}
}
