package net.swisstech.swissarmyknife.io;

import net.swisstech.log.Logger;
import net.swisstech.log.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Selector;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Utility Class to close several kinds of classes.
 * <p>
 * With Java 7 try-with-resources, this class is now basically obsolete
 *
 * @since 1.1.4
 */
public final class Closeables {

    private static final Logger LOG = LoggerFactory.getLogger(Closeables.class);

    /** private constructor for utility class */
    private Closeables() {
    }

    public static void close(AutoCloseable obj) {
        if (obj != null) {
            try {
                obj.close();
            } catch (Exception e) {
                LOG.error("Close failed for Closeable of type %s", obj.getClass().getName(), e);
            }
        }
    }

    public static void close(Selector obj) {
        if (obj != null) {
            try {
                obj.close();
            } catch (Exception e) {
                LOG.error("Close failed for Selector of type %s", obj.getClass().getName(), e);
            }
        }
    }

    public static void close(ServerSocket obj) {
        if (obj != null) {
            try {
                obj.close();
            } catch (Exception e) {
                LOG.error("Close failed for ServerSocket of type %s", obj.getClass().getName(), e);
            }
        }
    }

    public static void close(Socket obj) {
        if (obj != null) {
            try {
                obj.close();
            } catch (Exception e) {
                LOG.error("Close failed for Socket of type %s", obj.getClass().getName(), e);
            }
        }
    }

    public static void close(HttpURLConnection huc) {
        if (huc != null) {
            try {
                huc.disconnect();
            } catch (Exception e) {
                LOG.error("Disconnect failed for HttpURLConnection of type %s", huc.getClass().getName(), e);
            }
        }
    }

    public static void shutdownAndAwaitTermination(ExecutorService obj, long timeoutMillis) {
        // FIXME: proper error handling if await timeouts we should probably re-try with shutdownNow and as a last resort not unlike a kernel that sends TERM
        // and later KILL to all processes still running.
        if (obj != null) {
            obj.shutdown();
            try {
                if (!obj.awaitTermination(timeoutMillis, TimeUnit.MILLISECONDS)) {
                    List<Runnable> runnables = obj.shutdownNow();
                    LOG.warn("executorService failed to shut down, remaining runnables: %s", runnables);
                }
            } catch (InterruptedException e) {
                LOG.error("awaitTermination failed for ExecutorService of type %s", obj.getClass().getName(), e);
            }
        }
    }
}
