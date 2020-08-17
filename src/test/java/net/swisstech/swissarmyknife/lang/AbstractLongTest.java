package net.swisstech.swissarmyknife.lang;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AbstractLongTest {

	private static final class Yolo extends AbstractLong {

		private static final long serialVersionUID = -4227739792952896732L;

		public Yolo(long value) {
			super(value);
		}

		public Yolo(String value) {
			super(value);
		}
	}

	@Test
	public void testNewFromLong() {
		AssertJUnit.assertEquals(5L, new Yolo(5L).longValue());
		AssertJUnit.assertEquals(9L, new Yolo("9").longValue());
		AssertJUnit.assertEquals(8L, new Yolo("8").intValue());
		AssertJUnit.assertEquals(7f, new Yolo("7").floatValue());
		AssertJUnit.assertEquals(6d, new Yolo("6").doubleValue());
	}

	@Test
	public void testCompareTo() {
		Yolo yolo = new Yolo(8L);
		assertEquals(0, yolo.compareTo(yolo));

		assertEquals(1, new Yolo(7L).compareTo(null));
		assertEquals(1, new Yolo(6L).compareTo(new Yolo("5")));
		assertEquals(0, new Yolo(5L).compareTo(new Yolo("5")));
		assertEquals(-1, new Yolo(4L).compareTo(new Yolo("5")));
	}

	@Test
	public void testEquals() {
		Yolo yolo = new Yolo(3L);
		assertTrue(yolo.equals(yolo));
		assertFalse(yolo.equals(null));
		assertFalse(yolo.equals(new Object()));
		assertTrue(yolo.equals(new Yolo(3)));
		assertFalse(yolo.equals(new Yolo(4)));
	}

	@Test
	public void testHashCode() {
		assertEquals(99, new Yolo(99).hashCode());
	}

	@Test
	public void testToString() {
		assertEquals("123", new Yolo(123).toString());
	}
}
