package net.swisstech.swissarmyknife.lang;

import static org.testng.Assert.assertSame;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

public class ObjectsTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Objects.class);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void notNullNull() {
		Objects.notNull((Object) null);
	}

	@Test
	public void notNull() {
		Object o = new Object();
		assertSame(Objects.notNull(o), o);
	}
}
