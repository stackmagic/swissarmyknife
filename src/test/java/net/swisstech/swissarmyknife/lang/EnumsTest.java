package net.swisstech.swissarmyknife.lang;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class EnumsTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Enums.class);
	}

	@Test
	public void testNameOf() {
		assertNull(Enums.nameOf(null));
		assertEquals(Enums.nameOf(DummyEnum.WORLD), "WORLD");
	}

	@Test
	public void testNameOfWithDefault() {
		assertNull(Enums.nameOf(null, null));
		assertEquals(Enums.nameOf(null, ""), "");
		assertEquals(Enums.nameOf(null, "oops"), "oops");
		assertEquals(Enums.nameOf(DummyEnum.HELLO, "unused default"), "HELLO");
	}

	public static enum DummyEnum {
		HELLO,
		WORLD;
	}
}
