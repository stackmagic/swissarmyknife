package net.swisstech.swissarmyknife.lang;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class HexTest {

    @Test
    public void privateConstructor() throws IOException {
        PrivateConstructor.invoke(Hex.class);
    }

    @Test
    public void testToHexStringByte() {
        byte[] bytes = new byte[]{0, 1, 126, 127, -128, -127, -2, -1};
        String hex = Hex.toHexString(bytes);
        assertEquals(hex, "00017E7F8081FEFF");
    }

    @Test
    public void testToHexStringInt() {
        int[] ints = new int[]{0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xAA, 0xBB, 0xCC, 0xDD, 0xEE, 0xFF};
        String hex = Hex.toHexString(ints);
        assertEquals(hex, "00112233445566778899AABBCCDDEEFF");
    }

    @Test
    public void testToHexDumpStringByte() {
        //noinspection StringBufferReplaceableByString
        StringBuilder act = new StringBuilder();
        act.append("0000-0010    00 01 02 03 04 05 06 07  08 09 0A 0B 0C 0D 0E 0F    ........ ........\n");
        act.append("0010-0020    10 11 12 5A FF                                      ...Z.           \n");
        byte[] data = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 'Z', (byte) 0xFF};
        String hex = Hex.toHexDumpString(data);
        assertEquals(hex, act.toString());
    }

    @Test
    public void testToHexDumpStringInt() {
        //noinspection StringBufferReplaceableByString
        StringBuilder act = new StringBuilder();
        act.append("0000-0010    00 01 02 03 04 05 06 07  08 09 0A 0B 0C 0D 0E 0F    ........ ........\n");
        act.append("0010-0020    10 11 12 5A EE                                      ...Z.           \n");
        int[] data = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 'Z', 0xEE};
        String hex = Hex.toHexDumpString(data);
        assertEquals(hex, act.toString());
    }
}
