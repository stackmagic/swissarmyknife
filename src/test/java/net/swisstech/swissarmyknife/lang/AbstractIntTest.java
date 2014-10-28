package net.swisstech.swissarmyknife.lang;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.DtoTesterUtil;

import org.testng.annotations.Test;

public class AbstractIntTest {

	@Test
	public void testProperties() throws IOException {
		DtoTesterUtil.testAllProperties(new I(0));
	}

	@Test
	public void conversions() throws IOException {
		I i = new I(0);
		assertEquals(0, i.intValue());
		assertEquals(0, i.byteValue());
		assertEquals(0L, i.longValue());
		assertEquals(0, i.shortValue());
		assertEquals(0.0f, i.floatValue());
		assertEquals(0.0d, i.doubleValue());
	}

	@Test
	public void stringConstructorOk() {
		new I("0");
		new I("10");
		new I("200");
		new I("3000");
	}

	@Test(expectedExceptions = NumberFormatException.class)
	public void stringConstructorFail() {
		new I("XXX");
	}

	@Test
	public void comparable() {
		I zero = new I(0);
		I one = new I(1);
		I mone = new I(-1);

		assertEquals(zero.compareTo(null), 1);

		assertEquals(mone.compareTo(mone), 0);
		assertEquals(mone.compareTo(new I(-1)), 0);
		assertEquals(mone.compareTo(zero), -1);
		assertEquals(mone.compareTo(one), -1);

		assertEquals(zero.compareTo(mone), 1);
		assertEquals(zero.compareTo(zero), 0);
		assertEquals(zero.compareTo(new I(0)), 0);
		assertEquals(zero.compareTo(one), -1);

		assertEquals(one.compareTo(mone), 1);
		assertEquals(one.compareTo(zero), 1);
		assertEquals(one.compareTo(one), 0);
		assertEquals(one.compareTo(new I(1)), 0);
	}

	@Test
	public void equals() {
		I zero = new I(0);
		I one = new I(1);
		I mone = new I(-1);

		assertEquals(zero.equals(null), false);

		assertEquals(mone.equals(mone), true);
		assertEquals(mone.equals(new I(-1)), true);
		assertEquals(mone.equals(zero), false);
		assertEquals(mone.equals(one), false);

		assertEquals(zero.equals(mone), false);
		assertEquals(zero.equals(zero), true);
		assertEquals(zero.equals(new I(0)), true);
		assertEquals(zero.equals(one), false);

		assertEquals(one.equals(mone), false);
		assertEquals(one.equals(zero), false);
		assertEquals(one.equals(one), true);
		assertEquals(one.equals(new I(1)), true);
	}

	private static final class I extends AbstractInt {

		private static final long serialVersionUID = -2196624179636976483L;

		public I(int value) {
			super(value);
		}

		public I(String value) {
			super(value);
		}
	}
}
