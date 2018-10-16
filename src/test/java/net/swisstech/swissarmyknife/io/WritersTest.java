package net.swisstech.swissarmyknife.io;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

import static net.swisstech.swissarmyknife.test.Assert.assertInstanceOf;
import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertSame;

public class WritersTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Writers.class);
	}

	@Test
	public void bufferedReturnsSame() {
		BufferedWriter bw = mock(BufferedWriter.class);
		assertInstanceOf(BufferedWriter.class, bw);
		BufferedWriter b2 = Writers.buffered(bw);
		assertSame(b2, bw);
	}

	@Test
	public void bufferedWraps() {
		Writer w = mock(Writer.class);
		assertInstanceOf(Writer.class, w);
		BufferedWriter b = Writers.buffered(w);
		assertNotSame(b, w);
	}
}
