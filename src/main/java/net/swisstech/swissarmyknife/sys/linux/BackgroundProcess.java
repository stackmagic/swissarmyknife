package net.swisstech.swissarmyknife.sys.linux;

import net.swisstech.swissarmyknife.lang.InputStreams;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * simple util to launch a process, wait for a number of open ports and kill the process.
 *
 * @since 1.1.5
 */
public final class BackgroundProcess {

	private final ProcessWrapper process;

	private BackgroundProcess(ProcessWrapper process) {
		this.process = process;
	}

	public static BackgroundProcess launch(List<CharSequence> cmd, File workingDir) {
		ProcessWrapper process = ProcessWrapper.launch(cmd, workingDir);
		return new BackgroundProcess(process);
	}

	public BackgroundProcess waitForOpenPorts(Collection<Integer> ports, long timeout) {
		PortSnoop.waitForOpenPorts(process, ports, timeout);
		return this;
	}

	public BackgroundProcess waitForStringInStdout(String needle, long timeout) throws IOException {
		InputStreams.waitForOutput(needle, process.getInputStream(), timeout);
		return this;
	}

	public BackgroundProcess waitForStringInStderr(String needle, long timeout) throws IOException {
		InputStreams.waitForOutput(needle, process.getErrorStream(), timeout);
		return this;
	}

	public int shutdown() {
		return process.killWait(Signal.TERM);
	}
}
