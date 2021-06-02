package net.swisstech.swissarmyknife.io;

import java.io.BufferedWriter;
import java.io.Writer;

public final class Writers {

    /** private constructor for utility class */
    private Writers() {
    }

    public static BufferedWriter buffered(Writer writer) {
        if (writer instanceof BufferedWriter) {
            return (BufferedWriter) writer;
        }
        return new BufferedWriter(writer);
    }
}
