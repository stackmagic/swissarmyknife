package net.swisstech.swissarmyknife.lang;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

public class NumbersTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Numbers.class);
	}

	@Test
	public void tryParseLong() {
		assertNull(Numbers.tryParseLong("null"));
		assertEquals(Numbers.tryParseLong("1"), new Long(1));
		assertEquals(Numbers.tryParseLong("1", new Long(23)), new Long(1));
		assertEquals(Numbers.tryParseLong("1 3 4", new Long(23)), new Long(23));
		assertEquals(Numbers.tryParseLong(null, new Long(23)), new Long(23));
	}

	@Test
	public void tryParseInt() {
		assertNull(Numbers.tryParseInt("null"));
		assertEquals(Numbers.tryParseInt("1"), new Integer(1));
		assertEquals(Numbers.tryParseInt("1", new Integer(23)), new Integer(1));
		assertEquals(Numbers.tryParseInt("1 3 4", new Integer(23)), new Integer(23));
		assertEquals(Numbers.tryParseInt(null, new Integer(23)), new Integer(23));
	}

	@Test
	public void tryParseDouble() {
		assertNull(Numbers.tryParseDouble("null"));
		assertEquals(Numbers.tryParseDouble("1.2"), new Double(1.2));
		assertEquals(Numbers.tryParseDouble("1.2", new Double(23.4)), new Double(1.2));
		assertEquals(Numbers.tryParseDouble("1 3 4", new Double(23.4)), new Double(23.4));
		assertEquals(Numbers.tryParseDouble(null, new Double(23.4)), new Double(23.4));
	}
}
