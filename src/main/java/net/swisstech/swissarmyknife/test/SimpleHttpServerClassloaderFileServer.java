package net.swisstech.swissarmyknife.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * serve files from the classpath
 * @since 1.1.4
 */
public class SimpleHttpServerClassloaderFileServer implements HttpHandler {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleHttpServerClassloaderFileServer.class);

	private static final int HTTP_CODE_TWO_HUNDRED = 200;

	private static final int HTTP_CODE_FOUR_OH_FOUR = 404;

	private final ClassLoader classLoader;

	public SimpleHttpServerClassloaderFileServer(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	public void handle(HttpExchange ex) throws IOException {
		String uri = ex.getRequestURI().toString().substring(1);
		InputStream in = classLoader.getResourceAsStream(uri);

		if (in == null) {
			LOG.error(">>> 404 Not Found: " + uri);
			ex.sendResponseHeaders(HTTP_CODE_FOUR_OH_FOUR, -1);
			return;
		}
		else {
			LOG.error(">>> 200 OK:        " + uri);
			ex.sendResponseHeaders(HTTP_CODE_TWO_HUNDRED, 0);

			copy(in, ex.getResponseBody());
			in.close();

			drain(ex.getRequestBody());
			ex.close();
		}
	}

	private void copy(InputStream in, OutputStream out) throws IOException {
		int b = -1;
		while ((b = in.read()) != -1) {
			out.write(b);
		}

	}

	/** should be done according to the description of {@link HttpExchange}'s title "Terminating exchanges" */
	private void drain(InputStream in) throws IOException {
		int i = 0;
		while (true) {
			i = in.read();
			if (i == -1) {
				break;
			}
		}
	}
}
