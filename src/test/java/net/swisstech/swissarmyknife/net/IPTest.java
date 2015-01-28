package net.swisstech.swissarmyknife.net;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

public class IPTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(IP.class);
	}
}
