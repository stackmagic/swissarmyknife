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
		assertFalse(Strings.isNotBlank(null));
		assertFalse(Strings.isNotBlank(""));
		assertFalse(Strings.isNotBlank(" "));
		assertFalse(Strings.isNotBlank("    "));
		assertTrue(Strings.isNotBlank(" a"));
		assertTrue(Strings.isNotBlank("  a"));
		assertTrue(Strings.isNotBlank("b "));
		assertTrue(Strings.isNotBlank("b  "));
		assertTrue(Strings.isNotBlank(" c "));
		assertTrue(Strings.isNotBlank("  c  "));
	}

	@Test
	public void blank() {
		assertTrue(Strings.isBlank(null));
		assertTrue(Strings.isBlank(""));
		assertTrue(Strings.isBlank(" "));
		assertTrue(Strings.isBlank("    "));
		assertFalse(Strings.isBlank(" a"));
		assertFalse(Strings.isBlank("  a"));
		assertFalse(Strings.isBlank("b "));
		assertFalse(Strings.isBlank("b  "));
		assertFalse(Strings.isBlank(" c "));
		assertFalse(Strings.isBlank("  c  "));
	}

	@Test
	public void truncate() {
		String o = "hello world";
		assertEquals(Strings.truncate(o, 5), "hello... (6 Bytes skipped)");
		assertEquals(Strings.truncate(o, 15), o);
	}
}
