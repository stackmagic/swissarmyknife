package net.swisstech.swissarmyknife.lang;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class BoundedLongTest {

	@Test
	public void test() {
		assertEquals(new BoundedLong(-20, 20).get(), 0);
		assertEquals(new BoundedLong(10, 20).get(), 10);

		assertEquals(new BoundedLong(-20, 20, 100).get(), 20);
		assertEquals(new BoundedLong(10, 20, 50).get(), 20);

		BoundedLong bl = new BoundedLong(10, 20);
		assertEquals(bl.get(), 10);

		for (int i = 1; i <= 10; i++) {
			assertEquals(bl.increment(), 10 + i);
		}

		assertEquals(bl.get(), 20);
		assertEquals(bl.increment(), 20);

		for (int i = 1; i <= 10; i++) {
			assertEquals(bl.decrement(), 20-i);
		}

		assertEquals(bl.get(), 10);
		assertEquals(bl.decrement(), 10);
		assertEquals(bl.set(0), 10);
	}
}
