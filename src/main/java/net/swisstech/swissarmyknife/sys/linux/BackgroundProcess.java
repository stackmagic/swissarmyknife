package net.swisstech.swissarmyknife.sys.linux;

import static net.swisstech.swissarmyknife.sys.linux.Signal.TERM;

import java.io.File;
import java.util.Collection;
import java.util.List;

/**
 * simple util to launch a process, wait for a number of open ports and kill the process.
 * @since 1.1.5
 */
public final class BackgroundProcess {

	private final ProcessWrapper process;

	private BackgroundProcess(ProcessWrapper process) {
		this.process = process;
	}

	public static BackgroundProcess launch(List<String> cmd, File workingDir) {
		ProcessWrapper process = ProcessWrapper.launch(cmd, workingDir);
		return new BackgroundProcess(process);
	}

	public BackgroundProcess waitForOpenPorts(Collection<Integer> ports, long timeout) {
		PortSnoop.waitForOpenPorts(process, ports, timeout);
		return this;
	}

	int shutdown() {
		return process.killWait(TERM);
	}
}
