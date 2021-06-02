package net.swisstech.swissarmyknife.test;

import java.util.Random;

/**
 * just a few basic network utilities for testing
 *
 * @since 1.1.4
 */
public final class NetworkUtil {

    /** max value for a single ip's octet minus 1 for use by Random.nextInt() */
    private static final int MAX_OCTET = 253;

    /** max value allowed for a port */
    private static final int MAXPORT = 65535;

    /** we only use the upper half of the port range */
    private static final int HALFMAXPORT = MAXPORT / 2 - 1;

    private static final Random RANDOM = new Random();

    /** private constructor for utility class */
    private NetworkUtil() {
    }

    /** get a random port from the upper half of the range (32k to 64k) */
    public static int getRandomUnprivilegedPort() {
        return RANDOM.nextInt(HALFMAXPORT) + HALFMAXPORT;
    }

    /** get a random local ip from 127.0.[1..254].[1..254] */
    public static String getRandomLocalhostIp() {
        int a = getRandomIpComponent();
        int b = getRandomIpComponent();
        return String.format("127.0.%d.%d", a, b);
    }

    /** get a random ip component from the range 1..254 */
    private static int getRandomIpComponent() {
        return RANDOM.nextInt(MAX_OCTET) + 1;
    }
}
