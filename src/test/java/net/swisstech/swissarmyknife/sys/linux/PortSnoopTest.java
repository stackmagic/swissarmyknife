package net.swisstech.swissarmyknife.sys.linux;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;

import static net.swisstech.swissarmyknife.test.Assert.assertCollectionContainsAll;
import static net.swisstech.swissarmyknife.test.Assert.assertEmpty;
import static net.swisstech.swissarmyknife.util.Sets.newHashSet;

public class PortSnoopTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(PortSnoop.class);
	}

	@Test
	public void parsePids() {
		assertEmpty(PortSnoop.parsePids(""));
		assertEmpty(PortSnoop.parsePids("    \n   \t   abc"));
		assertCollectionContainsAll(PortSnoop.parsePids(" 1   \n  2 \t  5 ab10c"), newHashSet(1, 2, 5, 10));
	}
}
