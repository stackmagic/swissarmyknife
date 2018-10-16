package net.swisstech.swissarmyknife.sys.linux;

/**
 * wrapper exception for the many exceptions that can arise when working with processes, threads and reflection
 *
 * @since 1.1.5
 */
public class ProcessWrapperException extends RuntimeException {

	private static final long serialVersionUID = 1000214087520738951L;

	public ProcessWrapperException() {
		super();
	}

	public ProcessWrapperException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProcessWrapperException(String message) {
		super(message);
	}

	public ProcessWrapperException(Throwable cause) {
		super(cause);
	}
}
