package net.swisstech.swissarmyknife.util;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static net.swisstech.swissarmyknife.util.Maps.isEmpty;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * test the Maps
 */
public class MapsTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Maps.class);
	}

	@Test
	public void isEmptyNull() {
		assertTrue(isEmpty(null));
	}

	@Test
	public void isEmptyEmpty() {
		assertTrue(isEmpty(new HashMap<String, String>()));
	}

	@Test
	public void isEmptyFilled() {
		assertFalse(isEmpty(new MapBuilder<String, String>("Hello", "World").build()));
	}
}
