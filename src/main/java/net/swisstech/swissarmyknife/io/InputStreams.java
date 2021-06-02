package net.swisstech.swissarmyknife.io;

import net.swisstech.log.Logger;
import net.swisstech.log.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

import static net.swisstech.swissarmyknife.lang.Threads.sleepFor;

public final class InputStreams {

    private static final Logger LOG = LoggerFactory.getLogger(InputStreams.class);

    /** private constructor for utility class */
    private InputStreams() {
    }

    /** wait for the InputStream to yield the desired string or time is running out */
    public static void waitForOutput(String needle, InputStream haystack, long timeout) throws IOException {

        LOG.info("waiting until InputStream yields '%s'", needle);
        long start = System.currentTimeMillis();
        long end = start + timeout;

        int length = needle.length();
        int haystackPointer = 0;

        char[] needleChars = needle.toCharArray();
        char[] haystackChars = new char[length];

        // loop and sleep until string found
        while (true) {
            if (haystack.available() > 0) {
                int hay = haystack.read();
                if (hay == -1) {
                    throw new IllegalStateException("Stream closed while waiting for string '" + needle + "'");
                }

                int saveIdx = haystackPointer % length;
                haystackChars[saveIdx] = (char) hay;

                for (int i = 0; i < length; i++) {
                    int hayIdx = ((haystackPointer - i) % length);

                    // can't use negative indexes
                    if (hayIdx < 0) {
                        break;
                    }

                    // check char at index
                    int needleIdx = length - 1 - i;
                    char needleChar = needleChars[needleIdx];
                    char hayChar = haystackChars[hayIdx];
                    if (needleChar != hayChar) {
                        break;
                    } else if (i == length - 1) {
                        // the last chars matched so we're done here
                        return;
                    }
                }

                haystackPointer++;
            } else {
                sleepFor(100);
            }

            if (System.currentTimeMillis() > end) {
                throw new IllegalStateException("Timeout while waiting for string '" + needle + "' in inputStream. Waited for " + timeout + " millis");
            }
        }
    }
}
