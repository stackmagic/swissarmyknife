package net.swisstech.swissarmyknife.io;

import java.io.*;

public class Files {

    /** private constructor for utility class */
    private Files() {
    }

    /** @since 2.1.0 */
    public static BufferedReader asBufferedReader(File file) throws FileNotFoundException {
        return new BufferedReader(asReader(file));
    }

    /** @since 2.1.0 */
    public static BufferedWriter asBufferedWriter(File file) throws FileNotFoundException {
        return new BufferedWriter(asWriter(file));
    }

    /** @since 2.1.0 */
    public static Reader asReader(File file) throws FileNotFoundException {
        return new InputStreamReader(asInputStream(file));
    }

    /** @since 2.1.0 */
    public static Writer asWriter(File file) throws FileNotFoundException {
        return new OutputStreamWriter(asOutputStream(file));
    }

    /** @since 2.1.0 */
    public static BufferedInputStream asBufferedInputStream(File file) throws FileNotFoundException {
        return new BufferedInputStream(asInputStream(file));
    }

    /** @since 2.1.0 */
    public static BufferedOutputStream asBufferedOutputStream(File file) throws FileNotFoundException {
        return new BufferedOutputStream(asOutputStream(file));
    }

    /** @since 2.1.0 */
    public static InputStream asInputStream(File file) throws FileNotFoundException {
        return new FileInputStream(readable(file));
    }

    /** @since 2.1.0 */
    public static OutputStream asOutputStream(File file) throws FileNotFoundException {
        return new FileOutputStream(writable(file));
    }

    /** @since 2.1.0 */
    public static File readable(File file) {
        if (isReadable(file)) {
            return file;
        }

        throw new IllegalArgumentException("File " + file.getAbsolutePath() + " is not readable");
    }

    /** @since 2.1.0 */
    public static File writable(File file) {
        if (isWritable(file)) {
            return file;
        }

        throw new IllegalArgumentException("File " + file.getAbsolutePath() + " is not writable");
    }

    /** @since 2.1.0 */
    public static File executable(File file) {
        if (isExecutable(file)) {
            return file;
        }

        throw new IllegalArgumentException("File " + file.getAbsolutePath() + " is not executable");
    }

    public static boolean isReadable(File file) {
        return mustExist(file).canRead();
    }

    /** @since 2.1.0 */
    public static boolean isWritable(File file) {
        return mustExist(file).canWrite();
    }

    /** @since 2.1.0 */
    public static boolean isExecutable(File file) {
        return mustExist(file).canExecute();
    }

    /** @since 2.1.0 */
    public static File mustExist(File file) {
        if (doesntExist(file)) {
            throw new IllegalArgumentException("File " + file.getAbsolutePath() + " must exist but doesn't");
        }
        return file;
    }

    /** @since 2.1.0 */
    public static File mustNotExist(File file) {
        if (doesExist(file)) {
            throw new IllegalArgumentException("File " + file.getAbsolutePath() + " must not exist but does");
        }
        return file;
    }

    /** @since 2.1.0 */
    public static boolean doesExist(File file) {
        return file.exists();
    }

    /** @since 2.1.0 */
    public static boolean doesntExist(File file) {
        return !doesExist(file);
    }
}