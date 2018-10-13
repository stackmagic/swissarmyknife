package net.swisstech.swissarmyknife.lang;

import net.swisstech.swissarmyknife.lang.AbstractCharSequenceTest.Str;
import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.swisstech.swissarmyknife.lang.Strings.*;
import static net.swisstech.swissarmyknife.test.Assert.*;
import static org.testng.Assert.*;

/**
 * test the Strings
 */
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

	@Test
	public void asString() {
		assertNull(Strings.asString((String) null));
		String rv = Strings.asString(new Str("hello"));
		assertEquals(rv, "hello");
		assertInstanceOf(String.class, rv);
	}

	@Test
	public void asStringArray() {
		assertNull(Strings.asString((CharSequence[]) null));
		assertEmpty(Strings.asString(new CharSequence[0]));
		CharSequence[] cs = new CharSequence[]{new Str("hello"), "world"};
		String[] ss = Strings.asString(cs);
		assertSameSize(cs, ss);
		for (int i = 0; i < cs.length; i++) {
			assertEquals(ss[i].toString(), cs[i].toString());
		}
	}

	@Test
	public void asStringCollection() {
		assertNull(Strings.asString((List<CharSequence>) null));
		assertEmpty(Strings.asString(new ArrayList<CharSequence>()));
		List<CharSequence> cs = new ArrayList<>();
		cs.add(new Str("hello"));
		cs.add("world");
		List<String> ss = Strings.asString(cs);
		assertSameSize(cs, ss);
		for (int i = 0; i < cs.size(); i++) {
			assertEquals(ss.get(i).toString(), cs.get(i).toString());
		}
	}

	@Test
	public void breakString() {
		String test = "hello.world.this.is.a.very.long.string.and.will.be.split.where.the.dots.are";
		List<String> parts = Strings.breakString(test, ".", 16, String::length);
		assertSize(parts, 5);
		assertEquals(parts.get(0), "hello.world.this");
		assertEquals(parts.get(1), ".is.a.very.long.");
		assertEquals(parts.get(2), "string.and.will.");
		assertEquals(parts.get(3), "be.split.where.");
		assertEquals(parts.get(4), "the.dots.are");
	}

	@Test
	public void breakString2() {
		String test = "hello_world_this_is_a_very_long_string_and_will_be_split_where_the_dots_are";
		List<String> parts = Strings.breakString(test, ".", 16, String::length);
		assertSize(parts, 1);
		assertEquals(parts.get(0), test);
	}
}
