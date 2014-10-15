package net.swisstech.swissarmyknife.test;

import java.io.IOException;

import org.testng.annotations.Test;

public class PrivateConstructorTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(PrivateConstructor.class);
	}

	@Test
	public void shouldWorkFine() throws IOException {
		PrivateConstructor.invoke(PrivateConstructorTestHasPrivateDefaultConstructor.class);
	}

	@Test(expectedExceptions = IOException.class)
	public void shouldFailBecauseNoDefaultConstructor() throws IOException {
		PrivateConstructor.invoke(PrivateConstructorTestHasPrivateNonDefaultConstructor.class);
	}
}
