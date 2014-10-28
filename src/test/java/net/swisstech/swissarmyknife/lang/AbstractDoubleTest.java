package net.swisstech.swissarmyknife.lang;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.DtoTesterUtil;

import org.testng.annotations.Test;

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
		D one = new D(1);
		D mone = new D(-1);

		assertEquals(zero.compareTo(null), 1);

		assertEquals(mone.compareTo(mone), 0);
		assertEquals(mone.compareTo(new D(-1)), 0);
		assertEquals(mone.compareTo(zero), -1);
		assertEquals(mone.compareTo(one), -1);

		assertEquals(zero.compareTo(mone), 1);
		assertEquals(zero.compareTo(zero), 0);
		assertEquals(zero.compareTo(new D(0)), 0);
		assertEquals(zero.compareTo(one), -1);

		assertEquals(one.compareTo(mone), 1);
		assertEquals(one.compareTo(zero), 1);
		assertEquals(one.compareTo(one), 0);
		assertEquals(one.compareTo(new D(1)), 0);
	}

	@Test
	public void equals() {
		D zero = new D(0);
		D one = new D(1);
		D mone = new D(-1);

		assertEquals(zero.equals(null), false);

		assertEquals(mone.equals(mone), true);
		assertEquals(mone.equals(new D(-1)), true);
		assertEquals(mone.equals(zero), false);
		assertEquals(mone.equals(one), false);

		assertEquals(zero.equals(mone), false);
		assertEquals(zero.equals(zero), true);
		assertEquals(zero.equals(new D(0)), true);
		assertEquals(zero.equals(one), false);

		assertEquals(one.equals(mone), false);
		assertEquals(one.equals(zero), false);
		assertEquals(one.equals(one), true);
		assertEquals(one.equals(new D(1)), true);
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
