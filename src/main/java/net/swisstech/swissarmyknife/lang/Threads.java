package net.swisstech.swissarmyknife.lang;

/**
 * thread-related utils
 *
 * @since 1.1.5
 */
public final class Threads {

    /** private constructor for utility class */
    private Threads() {
    }

    public static boolean sleepUntil(long end) {
        return sleepFor(end - System.currentTimeMillis());
    }

    /**
     * Sleep for a certain amount of time and tell the caller whether or not to continue;
     *
     * @param time The amount of time to sleep (in millis)
     * @return Returns <code>true</code> if the caller may continue, <code>false</code> if we were interrupted and the caller must stop running.
     */
    public static boolean sleepFor(long time) {
        long end = time + System.currentTimeMillis();
        while (end > System.currentTimeMillis()) {
            long remainder = end - System.currentTimeMillis();
            try {
                //noinspection BusyWait
                Thread.sleep(remainder);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return true;
    }
}
