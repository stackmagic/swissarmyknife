package net.swisstech.swissarmyknife.lang;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

/** test the AbstractCharSequence */
public class AbstractCharSequenceTest {

	private static final class Str extends AbstractCharSequence {

		public Str(CharSequence value) {
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
	public void testEquals() {
		Str src = new Str("abc");
		assertTrue(src.equals(src));
		assertTrue(new Str("abc").equals(new Str("abc")));
	}
}
