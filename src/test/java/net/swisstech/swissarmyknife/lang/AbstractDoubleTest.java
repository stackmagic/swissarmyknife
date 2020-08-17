package net.swisstech.swissarmyknife.lang;

import net.swisstech.swissarmyknife.test.DtoTesterUtil;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class AbstractDoubleTest {

	@Test
	public void testProperties() throws IOException {
		DtoTesterUtil.testAllProperties(new D(0));
	}

	@Test
	public void conversions() throws IOException {
		D d = new D(0);
		assertEquals(0, d.intValue());
		assertEquals(0, d.byteValue());
		assertEquals(0L, d.longValue());
		assertEquals(0, d.shortValue());
		assertEquals(0.0f, d.floatValue());
		assertEquals(0.0d, d.doubleValue());
	}

	@Test
	public void stringConstructorOk() {
		new D("0");
		new D("10");
		new D("200");
		new D("3000");
	}

	@Test
	public void comparable() {
		D zero = new D(0);
		D onePos = new D(1);
		D oneNeg = new D(-1);

		assertEquals(zero.compareTo(null), 1);

		assertEquals(oneNeg.compareTo(oneNeg), 0);
		assertEquals(oneNeg.compareTo(new D(-1)), 0);
		assertEquals(oneNeg.compareTo(zero), -1);
		assertEquals(oneNeg.compareTo(onePos), -1);

		assertEquals(zero.compareTo(oneNeg), 1);
		assertEquals(zero.compareTo(zero), 0);
		assertEquals(zero.compareTo(new D(0)), 0);
		assertEquals(zero.compareTo(onePos), -1);

		assertEquals(onePos.compareTo(oneNeg), 1);
		assertEquals(onePos.compareTo(zero), 1);
		assertEquals(onePos.compareTo(onePos), 0);
		assertEquals(onePos.compareTo(new D(1)), 0);
	}

	@Test
	public void equals() {
		D zero = new D(0);
		D one = new D(1);
		D mone = new D(-1);

		assertFalse(zero.equals(null));

		assertTrue(mone.equals(mone));
		assertTrue(mone.equals(new D(-1)));
		assertFalse(mone.equals(zero));
		assertFalse(mone.equals(one));

		assertFalse(zero.equals(mone));
		assertTrue(zero.equals(zero));
		assertTrue(zero.equals(new D(0)));
		assertFalse(zero.equals(one));

		assertFalse(one.equals(mone));
		assertFalse(one.equals(zero));
		assertTrue(one.equals(one));
		assertTrue(one.equals(new D(1)));
	}

	private static final class D extends AbstractDouble {

		private static final long serialVersionUID = 2282907202308797176L;

		public D(int value) {
			super(value);
		}

		public D(String value) {
			super(value);
		}
	}
}
