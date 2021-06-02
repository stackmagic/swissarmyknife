package net.swisstech.swissarmyknife.io;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Selector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.*;

public class CloseablesTest {

    @Test
    public void privateConstructor() throws IOException {
        PrivateConstructor.invoke(Closeables.class);
    }

    @Test
    public void shouldCloseCloseable() throws IOException {
        Closeable c = mock(Closeable.class);
        Closeables.close(c);
        verify(c).close();
    }

    @Test
    public void shouldIgnoreNullCloseable() {
        Closeables.close((Closeable) null);
    }

    @Test
    public void shouldLogCloseableException() throws IOException {
        Closeable c = mock(Closeable.class);
        doThrow(new IOException("testing Closeable")).when(c).close();
        Closeables.close(c);
        verify(c).close();
    }

    @Test
    public void shouldCloseSelector() throws IOException {
        Selector s = mock(Selector.class);
        Closeables.close(s);
        verify(s).close();
    }

    @Test
    public void shouldIgnoreNullSelector() {
        Closeables.close((Selector) null);
    }

    @Test
    public void shouldLogSelectorException() throws IOException {
        Selector s = mock(Selector.class);
        doThrow(new IOException("testing Selector")).when(s).close();
        Closeables.close(s);
        verify(s).close();
    }

    @Test
    public void shouldCloseServerSocket() throws IOException {
        ServerSocket s = mock(ServerSocket.class);
        Closeables.close(s);
        verify(s).close();
    }

    @Test
    public void shouldIgnoreNullServerSocket() {
        Closeables.close((ServerSocket) null);
    }

    @Test
    public void shouldLogServerSocketException() throws IOException {
        ServerSocket s = mock(ServerSocket.class);
        doThrow(new IOException("testing ServerSocket")).when(s).close();
        Closeables.close(s);
        verify(s).close();
    }

    @Test
    public void shouldCloseSocket() throws IOException {
        Socket s = mock(Socket.class);
        Closeables.close(s);
        verify(s).close();
    }

    @Test
    public void shouldIgnoreNullSocket() {
        Closeables.close((Socket) null);
    }

    @Test
    public void shouldLogSocketException() throws IOException {
        Socket s = mock(Socket.class);
        doThrow(new IOException("testing Socket")).when(s).close();
        Closeables.close(s);
        verify(s).close();
    }

    @Test
    public void shouldCloseHttpURLConnection() {
        HttpURLConnection huc = mock(HttpURLConnection.class);
        Closeables.close(huc);
        verify(huc).disconnect();
    }

    @Test
    public void shouldIgnoreNullHttpURLConnection() {
        Closeables.close((HttpURLConnection) null);
    }

    @Test
    public void shouldLogHttpURLConnectionException() {
        HttpURLConnection huc = mock(HttpURLConnection.class);
        doThrow(new RuntimeException("testing HttpURLConnection")).when(huc).disconnect();
        Closeables.close(huc);
        verify(huc).disconnect();
    }

    @Test
    public void shouldCloseExecutorService() throws InterruptedException {
        ExecutorService s = mock(ExecutorService.class);
        Closeables.shutdownAndAwaitTermination(s, 555);
        verify(s).awaitTermination(555, TimeUnit.MILLISECONDS);
    }

    @Test
    public void shouldIgnoreNullExecutorService() {
        Closeables.shutdownAndAwaitTermination(null, 777);

    }

    @Test
    public void shouldLogInterruptedException() throws InterruptedException {
        ExecutorService s = mock(ExecutorService.class);
        doThrow(new InterruptedException("testing ExecutorService")).when(s).awaitTermination(999, TimeUnit.MILLISECONDS);
        Closeables.shutdownAndAwaitTermination(s, 999);
        verify(s).awaitTermination(999, TimeUnit.MILLISECONDS);
    }
}
