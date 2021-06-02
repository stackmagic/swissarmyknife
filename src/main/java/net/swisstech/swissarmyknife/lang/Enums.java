package net.swisstech.swissarmyknife.lang;

public final class Enums {

    /** private constructor for utility class */
    private Enums() {
    }

    public static String nameOf(Enum<?> e) {
        return nameOf(e, null);
    }

    public static String nameOf(Enum<?> e, String dflt) {
        if (e == null) {
            return dflt;
        }
        return e.name();
    }
}
