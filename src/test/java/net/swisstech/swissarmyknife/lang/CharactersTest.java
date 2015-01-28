package net.swisstech.swissarmyknife.lang;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

//TODO structurally exactly the same as Longs, Characters, Integers, Shorts etc... have 1 master and generate the rest!!

/**
 * some char number utils
 * @since 1.2.0
 */
public class CharactersTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Characters.class);
	}

	@Test
	public void isZero() {
		assertFalse(Characters.isZero((char) 1));
		assertTrue(Characters.isZero((char) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void zeroHi() {
		Characters.zero((char) 1);
	}

	@Test
	public void zero() {
		assertEquals(Characters.zero((char) 0), (char) 0);
	}

	@Test
	public void isPositive() {
		assertFalse(Characters.isPositive((char) 0));
		assertTrue(Characters.isPositive((char) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void positiveLo() {
		Characters.positive((char) 0);
	}

	@Test
	public void positive() {
		assertEquals(Characters.positive((char) 1), (char) 1);
	}

	@Test
	public void isInRangeInclusive() {
		assertTrue(Characters.isInRangeInclusive((char) 0, (char) 0, (char) 0));

		assertTrue(Characters.isInRangeInclusive((char) 0, (char) 0, (char) 1));
		assertTrue(Characters.isInRangeInclusive((char) 1, (char) 0, (char) 1));

		assertFalse(Characters.isInRangeInclusive((char) 0, (char) 1, (char) 1));
		assertFalse(Characters.isInRangeInclusive((char) 2, (char) 0, (char) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveHi() {
		Characters.inRangeInclusive((char) 2, (char) 0, (char) 1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeInclusiveLo() {
		Characters.inRangeInclusive((char) 0, (char) 1, (char) 2);
	}

	@Test
	public void inRangeInclusive() {
		assertEquals(Characters.inRangeInclusive((char) 0, (char) 0, (char) 0), (char) 0);
	}

	@Test
	public void isInRangeExclusive() {
		assertFalse(Characters.isInRangeExclusive((char) 0, (char) 0, (char) 0));
		assertFalse(Characters.isInRangeExclusive((char) 1, (char) 0, (char) 1));
		assertFalse(Characters.isInRangeExclusive((char) 0, (char) 0, (char) 1));

		assertTrue(Characters.isInRangeExclusive((char) 3, (char) 2, (char) 4));
		assertTrue(Characters.isInRangeExclusive((char) 2, (char) 1, (char) 3));
		assertTrue(Characters.isInRangeExclusive((char) 1, (char) 0, (char) 2));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveHi() {
		Characters.inRangeExclusive((char) 2, (char) 0, (char) 1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void inRangeExclusiveLo() {
		Characters.inRangeExclusive((char) 0, (char) 0, (char) 2);
	}

	@Test
	public void inRangeExclusive() {
		assertEquals(Characters.inRangeExclusive((char) 1, (char) 0, (char) 2), (char) 1);
	}

	@Test
	public void isEqual() {
		assertFalse(Characters.isEqual((char) 0, (char) 1));
		assertFalse(Characters.isEqual((char) 1, (char) 0));

		assertTrue(Characters.isEqual((char) 0, (char) 0));
		assertTrue(Characters.isEqual((char) 1, (char) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void equalFalse() {
		Characters.equal((char) 0, (char) 1);
	}

	@Test
	public void equal() {
		assertEquals(Characters.equal((char) 0, (char) 0), (char) 0);
	}

	@Test
	public void isGreater() {
		assertTrue(Characters.isGreater((char) 1, (char) 0));
		assertFalse(Characters.isGreater((char) 1, (char) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterLo() {
		Characters.greater((char) 1, (char) 1);
	}

	@Test
	public void greater() {
		assertEquals(Characters.greater((char) 1, (char) 0), (char) 1);
	}

	@Test
	public void isGreaterOrEqual() {
		assertFalse(Characters.isGreaterOrEqual((char) 0, (char) 1));
		assertTrue(Characters.isGreaterOrEqual((char) 1, (char) 1));
		assertTrue(Characters.isGreaterOrEqual((char) 2, (char) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void greaterOrEqualLo() {
		Characters.greaterOrEqual((char) 0, (char) 1);
	}

	@Test
	public void greaterOrEqual() {
		assertEquals(Characters.greaterOrEqual((char) 1, (char) 1), (char) 1);
		assertEquals(Characters.greaterOrEqual((char) 2, (char) 1), (char) 2);
	}

	@Test
	public void isSmaller() {
		assertFalse(Characters.isSmaller((char) 1, (char) 1));
		assertTrue(Characters.isSmaller((char) 0, (char) 1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerHi() {
		Characters.smaller((char) 1, (char) 1);
	}

	@Test
	public void smaller() {
		assertEquals(Characters.smaller((char) 0, (char) 1), (char) 0);
	}

	@Test
	public void isSmallerOrEqual() {
		assertFalse(Characters.isSmallerOrEqual((char) 1, (char) 0));
		assertTrue(Characters.isSmallerOrEqual((char) 0, (char) 0));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void smallerOrEqualHi() {
		Characters.smallerOrEqual((char) 1, (char) 0);
	}

	@Test
	public void smallerOrEqual() {
		assertEquals(Characters.smallerOrEqual((char) 0, (char) 0), (char) 0);
		assertEquals(Characters.smallerOrEqual((char) 0, (char) 1), (char) 0);
	}

	@Test
	public void limit() {
		assertEquals(Characters.limit((char) 0, (char) 0, (char) 0), (char) 0);
		assertEquals(Characters.limit((char) 5, (char) 0, (char) 0), (char) 0);

		assertEquals(Characters.limit((char) 5, (char) 5, (char) 10), (char) 5);
		assertEquals(Characters.limit((char) 0, (char) 5, (char) 10), (char) 5);

		assertEquals(Characters.limit((char) 5, (char) 0, (char) 5), (char) 5);
		assertEquals(Characters.limit((char) 10, (char) 0, (char) 5), (char) 5);
	}
}
