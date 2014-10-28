package net.swisstech.swissarmyknife.iso;

import static net.swisstech.swissarmyknife.test.Assert.assertGreaterThan;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.io.File;
import java.io.IOException;

import net.swisstech.log.Logger;
import net.swisstech.log.LoggerFactory;
import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

public class Iso639Test {

	private static final Logger LOG = LoggerFactory.getLogger(Iso639Test.class);

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Iso639.class);
	}

	@Test
	public void testNullCode() {
		assertNull(Iso639.convert(null));
	}

	@Test
	public void testUnknownCode() {
		String asd = "HelloWorldThisIsNotALanguageCode";
		assertEquals(Iso639.convert(asd), asd);
	}

	@Test
	public void test() {
		if (new File(Iso639.FILE_NAME).exists()) {
			assertGreaterThan(Iso639.getMappingCount(), 0);
			assertEquals(Iso639.convert("ara"), "ar");
			assertEquals(Iso639.convert("deu"), "de");
			assertEquals(Iso639.convert("eng"), "en");
			assertEquals(Iso639.convert("ger"), "de");
			assertEquals(Iso639.convert("tur"), "tr");

			assertEquals(Iso639.convert("ARA"), "ar");
			assertEquals(Iso639.convert("DEU"), "de");
			assertEquals(Iso639.convert("ENG"), "en");
			assertEquals(Iso639.convert("GER"), "de");
			assertEquals(Iso639.convert("TUR"), "tr");
		}
		else {
			LOG.error("No ISO639 Mappings available, skipping tests");
		}
	}
}
