package net.swisstech.swissarmyknife.util;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static net.swisstech.swissarmyknife.util.Maps.*;
import static org.testng.Assert.*;

/**
 * test the Maps
 */
public class MapsTest {

	private static final Map<String, String> EMPTY = new HashMap<>();
	private static final Map<String, String> MAP = new MapBuilder<>("Hello", "World").build();

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Maps.class);
	}

	@Test()
	public void emptyNull() {
		assertNull(empty(null));
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Expected map to be empty but it isn't")
	public void emptyNotEmpty() {
		empty(MAP);
	}

	@Test
	public void emptyEmpty() {
		assertSame(empty(EMPTY), EMPTY);
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Expected map to not be empty but it is")
	public void notEmptyNull() {
		notEmpty(null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Expected map to not be empty but it is")
	public void notEmptyEmpty() {
		notEmpty(EMPTY);
	}

	@Test
	public void notEmptyFilled() {
		assertSame(notEmpty(MAP), MAP);
	}

	@Test
	public void isNotEmptyNull() {
		assertFalse(isNotEmpty(null));
	}

	@Test
	public void isNotEmptyEmpty() {
		assertFalse(isNotEmpty(EMPTY));
	}

	@Test
	public void isNotEmptyFilled() {
		assertTrue(isNotEmpty(MAP));
	}

	@Test
	public void isEmptyNull() {
		assertTrue(isEmpty(null));
	}

	@Test
	public void isEmptyEmpty() {
		assertTrue(isEmpty(EMPTY));
	}

	@Test
	public void isEmptyFilled() {
		assertFalse(isEmpty(MAP));
	}
}
