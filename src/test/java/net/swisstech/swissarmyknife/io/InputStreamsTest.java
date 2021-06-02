package net.swisstech.swissarmyknife.io;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamsTest {

    @Test
    public void waitForOutputSuccess() throws IOException {
        String needle = "hello world!";
        String haystack = "lorem ipsum dolor sit amet he he hello world! from here on it should be ignored";
        InputStream haystackStream = new ByteArrayInputStream(haystack.getBytes());
        InputStreams.waitForOutput(needle, haystackStream, 100);
    }

    @Test(expectedExceptions = {IllegalStateException.class}, expectedExceptionsMessageRegExp = "Timeout while waiting .*")
    public void waitForOutputTimeout() throws IOException {
        String needle = "needle";
        String haystack = "yeah the search term won't occur in this string so it'll timeout";
        InputStream haystackStream = new ByteArrayInputStream(haystack.getBytes());
        InputStreams.waitForOutput(needle, haystackStream, 100);
    }
}
