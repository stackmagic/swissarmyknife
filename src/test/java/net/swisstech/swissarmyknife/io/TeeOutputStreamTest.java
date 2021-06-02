package net.swisstech.swissarmyknife.io;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.OutputStream;

import static org.mockito.Mockito.*;

public class TeeOutputStreamTest {

    @Test
    public void callBothStreams() throws IOException {
        OutputStream os1 = mock(OutputStream.class);
        OutputStream os2 = mock(OutputStream.class);
        TeeOutputStream tos = new TeeOutputStream(os1, os2);

        tos.write(42);
        verify(os1).write(42);
        verify(os2).write(42);

        byte[] bytes = new byte[]{1, 2, 3};
        tos.write(bytes);
        verify(os1).write(bytes);
        verify(os2).write(bytes);

        tos.write(bytes, 1, 1);
        verify(os1).write(bytes, 1, 1);
        verify(os2).write(bytes, 1, 1);

        tos.flush();
        verify(os1).flush();
        verify(os2).flush();

        tos.close();
        verify(os1).close();
        verify(os2).close();

        verifyNoMoreInteractions(os1, os2);
    }
}
