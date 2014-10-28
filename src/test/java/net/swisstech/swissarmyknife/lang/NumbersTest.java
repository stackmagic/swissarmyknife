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
	public void tryParseInt_correctlyFormedInteger_returnsParsedInt() {
		assertEquals(Numbers.tryParseInt("1"), new Integer(1));
	}

	@Test
	public void tryParseInt_malformedInt_returnsNull() {
		assertNull(Numbers.tryParseInt("null"));
	}

	@Test
	public void tryParseIntWithDefault_correctlyFormedInteger_returnsParsedInt() {
		assertEquals(Numbers.tryParseInt("1", new Integer(23)), new Integer(1));
	}

	@Test
	public void tryParseIntWithDefault_malformedInt_returnsDefault() {
		assertEquals(Numbers.tryParseInt("1 3 4", new Integer(23)), new Integer(23));
	}

	@Test
	public void tryParseIntWithDefault_stringIsNull_returnsDefault() {
		assertEquals(Numbers.tryParseInt(null, new Integer(23)), new Integer(23));
	}

	@Test
	public void tryParseDouble_correctlyFormedDouble_returnsParsedDouble() {
		assertEquals(Numbers.tryParseDouble("1.2"), new Double(1.2));
	}

	@Test
	public void tryParseDouble_malformedDouble_returnsNull() {
		assertNull(Numbers.tryParseDouble("null"));
	}

	@Test
	public void tryParseDoubleWithDefault_correctlyFormedDouble_returnsParsedDouble() {
		assertEquals(Numbers.tryParseDouble("1.2", new Double(23.4)), new Double(1.2));
	}

	@Test
	public void tryParseDoubleWithDefault_malformedDouble_returnsDefault() {
		assertEquals(Numbers.tryParseDouble("1 3 4", new Double(23.4)), new Double(23.4));
	}

	@Test
	public void tryParseDoubleWithDefault_stringIsNull_returnsDefault() {
		assertEquals(Numbers.tryParseDouble(null, new Double(23.4)), new Double(23.4));
	}
}
