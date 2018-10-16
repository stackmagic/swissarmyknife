package net.swisstech.swissarmyknife.test;

import org.testng.annotations.Test;

import java.io.IOException;

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

	@Test(expectedExceptions = AssertionError.class)
	public void shouldFailWithPublicConstructor() throws IOException {
		PrivateConstructor.invoke(PrivateConstructorTestHasPublicConstructor.class);
	}
}
