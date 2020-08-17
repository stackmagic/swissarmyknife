package net.swisstech.swissarmyknife.lang;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AbstractCharSequenceTest {

	public static final class Str extends AbstractCharSequence {
		public Str(CharSequence value) {
			super(value);
		}
	}

	public static final class Str2 extends AbstractCharSequence {
		public Str2(CharSequence value) {
			super(value);
		}
	}

	@Test
	public void testLength() {
		assertEquals(0, new Str("").length());
		assertEquals(1, new Str("a").length());
		assertEquals(3, new Str("abc").length());
	}

	@Test
	public void testCharAt() {
		assertEquals('c', new Str("abc").charAt(2));
	}

	@Test
	public void testSubSequence() {
		assertEquals("cd", new Str("abcdef").subSequence(2, 4));
	}

	@Test
	public void testHashCode() {
		new Str("abc").hashCode();
	}

	@Test
	public void testToString() {
		assertEquals("abc", new Str("abc").toString());
	}

	@Test
	@SuppressWarnings({"SimplifiedTestNGAssertion", "EqualsWithItself", "ConstantConditions", "EqualsBetweenInconvertibleTypes"})
	public void testEquals() {
		Str src = new Str("abc");
		assertTrue(src.equals(src));
		assertTrue(new Str("abc").equals(new Str("abc")));
		assertFalse(src.equals(null));
		assertFalse(src.equals(new Str2("x")));
		assertFalse(src.equals(new Str(null)));
		assertFalse(new Str(null).equals(src));
		assertTrue(new Str(null).equals(new Str(null)));
	}

	@Test
	public void compareTo() {
		Str a1 = new Str("a");
		Str a2 = new Str("a");
		Str b1 = new Str("b");
		Str c1 = new Str("c");

		//noinspection EqualsWithItself
		assertEquals(a1.compareTo(a1), 0);
		assertEquals(a1.compareTo(a2), 0);

		assertEquals(a1.compareTo(b1), -1);
		assertEquals(a1.compareTo(c1), -2);

		assertEquals(b1.compareTo(c1), -1);
		assertEquals(b1.compareTo(a1), 1);

		assertEquals(c1.compareTo(b1), 1);
		assertEquals(c1.compareTo(a1), 2);

		Str s = new Str("short");
		Str l = new Str("loooooooooooong");
		assertEquals(s.compareTo(l), -10);
		assertEquals(l.compareTo(s), 10);
	}
}
