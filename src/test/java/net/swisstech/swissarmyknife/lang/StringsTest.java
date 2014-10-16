package net.swisstech.swissarmyknife.lang;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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
	public void notBlank() {
		assertFalse(Strings.isNotEmpty(null));
		assertFalse(Strings.isNotEmpty(""));
		assertFalse(Strings.isNotEmpty(" "));
		assertFalse(Strings.isNotEmpty("    "));
		assertTrue(Strings.isNotEmpty(" a"));
		assertTrue(Strings.isNotEmpty("  a"));
		assertTrue(Strings.isNotEmpty("b "));
		assertTrue(Strings.isNotEmpty("b  "));
		assertTrue(Strings.isNotEmpty(" c "));
		assertTrue(Strings.isNotEmpty("  c  "));
	}

	@Test
	public void blank() {
		assertTrue(Strings.isEmpty(null));
		assertTrue(Strings.isEmpty(""));
		assertTrue(Strings.isEmpty(" "));
		assertTrue(Strings.isEmpty("    "));
		assertFalse(Strings.isEmpty(" a"));
		assertFalse(Strings.isEmpty("  a"));
		assertFalse(Strings.isEmpty("b "));
		assertFalse(Strings.isEmpty("b  "));
		assertFalse(Strings.isEmpty(" c "));
		assertFalse(Strings.isEmpty("  c  "));
	}

	@Test
	public void truncate() {
		String o = "hello world";
		assertEquals(Strings.truncate(o, 5), "hello... (6 Bytes skipped)");
		assertEquals(Strings.truncate(o, 15), o);
	}
}
