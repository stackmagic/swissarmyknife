package net.swisstech.swissarmyknife.io;

import static net.swisstech.swissarmyknife.test.Assert.assertInstanceOf;
import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertSame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

public class ReadersTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Readers.class);
	}

	@Test
	public void bufferedReturnsSame() {
		BufferedReader br = mock(BufferedReader.class);
		assertInstanceOf(BufferedReader.class, br);
		BufferedReader b2 = Readers.buffered(br);
		assertSame(b2, br);
	}

	@Test
	public void bufferedWraps() {
		Reader r = mock(Reader.class);
		assertInstanceOf(Reader.class, r);
		BufferedReader b = Readers.buffered(r);
		assertNotSame(b, r);
	}
}
