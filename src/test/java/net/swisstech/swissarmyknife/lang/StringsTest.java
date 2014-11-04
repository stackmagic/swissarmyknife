package net.swisstech.swissarmyknife.lang;

import static net.swisstech.swissarmyknife.lang.Strings.blank;
import static net.swisstech.swissarmyknife.lang.Strings.isBlank;
import static net.swisstech.swissarmyknife.lang.Strings.isNotBlank;
import static net.swisstech.swissarmyknife.lang.Strings.notBlank;
import static net.swisstech.swissarmyknife.lang.Strings.truncate;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

/** test the Strings */
public class StringsTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Strings.class);
	}

	@Test
	public void isNotBlankOk() {
		assertFalse(isNotBlank(null));
		assertFalse(isNotBlank(""));
		assertFalse(isNotBlank(" "));
		assertFalse(isNotBlank("    "));
		assertTrue(isNotBlank(" a"));
		assertTrue(isNotBlank("  a"));
		assertTrue(isNotBlank("b "));
		assertTrue(isNotBlank("b  "));
		assertTrue(isNotBlank(" c "));
		assertTrue(isNotBlank("  c  "));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void notBlankNull() {
		notBlank(null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void notBlankEmpty() {
		notBlank("");
	}

	@Test
	public void notBlankOk() {
		notBlank("x");
	}

	@Test
	public void isBlankOk() {
		assertTrue(isBlank(null));
		assertTrue(isBlank(""));
		assertTrue(isBlank(" "));
		assertTrue(isBlank("    "));
		assertFalse(isBlank(" a"));
		assertFalse(isBlank("  a"));
		assertFalse(isBlank("b "));
		assertFalse(isBlank("b  "));
		assertFalse(isBlank(" c "));
		assertFalse(isBlank("  c  "));
	}

	@Test
	public void blankNullOk() {
		assertNull(blank(null));
	}

	@Test
	public void blankEmptyOk() {
		assertEquals(blank(""), "");
		assertEquals(blank("  "), "  ");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void blankFail() {
		blank("x");
	}

	@Test
	public void truncateOk() {
		String o = "hello world";
		assertEquals(truncate(o, 5), "hello... (6 Bytes skipped)");
		assertEquals(truncate(o, 15), o);
	}
}
