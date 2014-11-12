package net.swisstech.swissarmyknife.sys.linux;

import static net.swisstech.swissarmyknife.lang.Strings.isNotBlank;
import static net.swisstech.swissarmyknife.lang.Threads.sleepFor;
import static net.swisstech.swissarmyknife.sys.linux.Signal.TERM;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.swisstech.log.Logger;
import net.swisstech.log.LoggerFactory;

/**
 * util to check for open ports with a timeout, to wait until a process is ready so you can run tests against it
 * @since 1.1.5
 */
public final class PortSnoop {

	private static final Logger LOG = LoggerFactory.getLogger(PortSnoop.class);

	/** private constructor for utility class */
	private PortSnoop() {}

	/** wait for the process to be the owner of all the ports or time is running out */
	public static void waitForOpenPorts(ProcessWrapper process, Collection<Integer> ports, long timeout) {

		LOG.info("[%s] waiting until all of these ports are open: %s", process, ports);
		long start = System.currentTimeMillis();
		long end   = start + timeout;

		// loop and sleep until all expected ports are open
		while (true) {

			// get what processes have opened the ports we're interested in
			Map<Integer, Integer> portToPid = getPortToPid(ports);
			LOG.debug("[%d] Ports open right now with their pids: %s", process.getPid(), portToPid);

			// check for multiple processes owning our ports
			// TODO some programs may start subprocesses with new pids and we may allow for that
			Set<Integer> pids = new HashSet<Integer>();
			pids.addAll(portToPid.values());

			if (!pids.isEmpty() && pids.size() != 1) {
				process.killWait(TERM);
				throw new IllegalStateException("Ports are spread across multiple processes, bailing! Go check out the involved processes: " + pids);
			}

			if (!pids.isEmpty() && !pids.contains(process.getPid())) {
				process.killWait(TERM);
				throw new IllegalStateException("Port is owned by a different process, bailing! Go check out the other process: " + pids);
			}

			// see if we've got all ports we want
			Set<Integer> found = portToPid.keySet();
			if (found.containsAll(ports) && ports.containsAll(found)) {
				long duration = System.currentTimeMillis() - start;
				LOG.debug("[%d] All ports we want are open! Process is ready after %d millis", process.getPid(), duration);
				break;
			}

			// process must still be running, if it exited something's bad
			try {
				int rv = process.exitValue();
				throw new IllegalStateException("Process has exited with exit code " + rv);
			}
			catch (IllegalThreadStateException e) {
				// ignore, process is still running, all is good
			}

			// timeout!
			if (System.currentTimeMillis() > end) {
				process.killWait(TERM);
				throw new IllegalStateException("Timeout while waiting for process to start (was waiting for ports: " + ports + ", had " + portToPid + ", waited for " + timeout + " millis)");
			}

			// wait a bit before checking again
			sleepFor(100);
		}
	}

	/**
	 * returns a map of the supplied ports mapping to the process pid owning the open port. if there's no entry for a supplied port in the map, there's no
	 * process owning it (yet)
	 */
	public static Map<Integer, Integer> getPortToPid(Collection<Integer> ports) {
		Map<Integer, Integer> map =new HashMap<Integer, Integer>();
		for (Integer port : ports) {
			String cmd = "lsof -ti :" + port;
			String[] cmds = cmd.split(" ");
			String pid = ProcessWrapper.launchWaitText(cmds, null);
			if (isNotBlank(pid)) {
				map.put(port, Integer.parseInt(pid.trim()));
			}
		}
		return map;
	}
}
