package net.swisstech.swissarmyknife.sys.linux;

import static net.swisstech.swissarmyknife.io.Closeables.close;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

/**
 * <ul>
 * <li>A bunch of factory methods for simple cases of launching processes, see the launch* methods</li>
 * <li>Some extras like getPid() and kill(signal)</li>
 * </ul>
 * @since 1.1.5
 */
public final class ProcessWrapper extends Process {

	// TODO add waitFor(timeout)
	// TODO add waitForOrKill(timeout, signal)
	// for the timeout variants we should start another thread that waits on the process
	// and we sleep until the time has expired, then interrupt the waiting thread

	private final Process process;
	private Integer pid;

	public ProcessWrapper(Process process) {
		this.process = process;
	}

	public static String launchWaitText(String[] command, File workingDir) {
		ProcessWrapper pw = doLaunch(new ProcessBuilder(command), workingDir);
		try {
			pw.waitFor();
		}
		catch (InterruptedException e) {
			throw new ProcessWrapperException(e);
		}

		return pw.getStdOut();
	}

	public static ProcessWrapper launch(String[] command, File workingDir) {
		return launch(new ProcessBuilder(command), workingDir);
	}

	public static int launchWait(String[] command, File workingDir) {
		try {
			return launch(new ProcessBuilder(command), workingDir).waitFor();
		}
		catch (InterruptedException e) {
			throw new ProcessWrapperException(e);
		}
	}

	public static ProcessWrapper launch(List<String> command, File workingDir) {
		return launch(new ProcessBuilder(command), workingDir);
	}

	public static int launchWait(List<String> command, File workingDir) {
		try {
			return launch(new ProcessBuilder(command), workingDir).waitFor();
		}
		catch (InterruptedException e) {
			throw new ProcessWrapperException(e);
		}
	}

	public static ProcessWrapper launch(ProcessBuilder pb, File workingDir) {
		pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		pb.redirectError(ProcessBuilder.Redirect.INHERIT);
		return doLaunch(pb, workingDir);
	}

	public static ProcessWrapper doLaunch(ProcessBuilder pb, File workingDir) {
		if (workingDir != null) {
			pb.directory(workingDir);
		}

		try {
			Process process = pb.start();
			return new ProcessWrapper(process);
		}
		catch (IOException e) {
			throw new ProcessWrapperException(e);
		}
	}

	/** this returns a new process, which is the kill command executed to kill this process */
	public ProcessWrapper kill(Signal signal) {
		String cmd = String.format("/bin/kill -%s %d", signal.name(), pid);
		String[] cmds = cmd.split(" ");
		return launch(cmds, null);
	}

	public int killWait(Signal signal) {
		try {
			return kill(signal).waitFor();
		}
		catch (InterruptedException e) {
			throw new ProcessWrapperException(e);
		}
	}

	public int getPid() {
		if (pid == null) {
			extractPid();
		}
		return pid.intValue();
	}

	private void extractPid() {
		try {
			Class<? extends Process> clazz = process.getClass();
			Field pidField = clazz.getDeclaredField("pid");
			pidField.setAccessible(true);
			pid = pidField.getInt(process);
		}
		catch (SecurityException e) {
			throw new ProcessWrapperException(e);
		}
		catch (NoSuchFieldException e) {
			throw new ProcessWrapperException(e);
		}
		catch (IllegalAccessException e) {
			throw new ProcessWrapperException(e);
		}
		catch (IllegalArgumentException e) {
			throw new ProcessWrapperException(e);
		}
	}

	public String getStdOut() {
		StringBuilder sb = new StringBuilder();
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		char[] buf = new char[4096];

		try {
			while (true) {
				int n = isr.read(buf);
				if (n == -1) {
					break;
				}

				sb.append(buf, 0, n);
			}
		}
		catch (IOException e) {
			throw new ProcessWrapperException(e);
		}
		finally {
			close(isr);
		}

		return sb.toString();
	}

	/** delegates to wrapped process object */
	@Override
	public OutputStream getOutputStream() {
		return process.getOutputStream();
	}

	/** delegates to wrapped process object */
	@Override
	public InputStream getInputStream() {
		return process.getInputStream();
	}

	/** delegates to wrapped process object */
	@Override
	public InputStream getErrorStream() {
		return process.getErrorStream();
	}

	/** delegates to wrapped process object */
	@Override
	public int waitFor() throws InterruptedException {
		return process.waitFor();
	}

	/** delegates to wrapped process object */
	@Override
	public int exitValue() {
		return process.exitValue();
	}

	/** delegates to wrapped process object */
	@Override
	public void destroy() {
		process.destroy();
	}

	/** delegates to wrapped process object */
	@Override
	public String toString() {
		return process.toString();
	}
}
