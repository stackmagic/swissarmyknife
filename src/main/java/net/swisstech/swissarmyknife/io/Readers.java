package net.swisstech.swissarmyknife.io;

import java.io.BufferedReader;
import java.io.Reader;

public final class Readers {

    /** private constructor for utility class */
    private Readers() {
    }

    public static BufferedReader buffered(Reader reader) {
        if (reader instanceof BufferedReader) {
            return (BufferedReader) reader;
        }
        return new BufferedReader(reader);
    }
}
