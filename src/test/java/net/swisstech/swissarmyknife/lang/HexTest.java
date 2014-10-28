package net.swisstech.swissarmyknife.lang;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

/** test the HexDump */
public class HexTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Hex.class);
	}

	@Test
	public void testDump() {
		StringBuilder act = new StringBuilder();
		act.append("0000-0010    00 01 02 03 04 05 06 07  08 09 0A 0B 0C 0D 0E 0F    ........ ........\n");
		act.append("0010-0020    10 11 12 5A EE                                      ...Z.           \n");
		int[] data = new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 'Z', 0xEE };
		String hex = Hex.toHexDumpString(data);
		assertEquals(hex, act.toString());
	}
}
