package net.swisstech.swissarmyknife.test;

import com.sun.net.httpserver.HttpServer;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * just a simple http server that can be embedded in tests, does simple file serving, could be extended to call a custom controller if needed
 *
 * @since 1.1.4
 */
public class SimpleHttpServer implements Closeable {

	private final HttpServer server;

	public SimpleHttpServer(int port, ClassLoader classLoader) throws IOException {
		server = HttpServer.create(new InetSocketAddress(port), 0);
		server.createContext("/", new SimpleHttpServerClassloaderFileServer(classLoader));
		server.start();
	}

	@Override
	public void close() throws IOException {
		server.stop(0);
	}
}
