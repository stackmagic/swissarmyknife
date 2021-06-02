package net.swisstech.swissarmyknife.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * yes, commons-io has something like this too but I don't want to pull in an entire jar for a single class
 *
 * @since 1.1.5
 */
class TeeOutputStream extends OutputStream {

    private final OutputStream streamA;
    private final OutputStream streamB;

    public TeeOutputStream(OutputStream streamA, OutputStream streamB) {
        this.streamA = streamA;
        this.streamB = streamB;
    }

    @Override
    public void write(int b) throws IOException {
        streamA.write(b);
        streamB.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        streamA.write(b);
        streamB.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        streamA.write(b, off, len);
        streamB.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        streamA.flush();
        streamB.flush();
    }

    @Override
    public void close() throws IOException {
        streamA.close();
        streamB.close();
    }
}
