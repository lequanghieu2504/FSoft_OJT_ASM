package fa.training.utils;

public final class Validator {
    private Validator() {
    }

    public static boolean isValidCourseCode(String code) {
        if (code == null) return false;
        return code.matches("^FW\\d{3}$");
    }

    public static boolean isValidStatus(String status) {
        if (status == null) return false;
        String s = normalize(status);
        return "active".equals(s) || "in-active".equals(s);
    }

    public static boolean isValidFlag(String flag) {
        if (flag == null) return false;
        String f = normalize(flag);
        return "optional".equals(f) || "mandatory".equals(f) || "n/a".equals(f);
    }

    public static String normalize(String value) {
        return value.trim().toLowerCase();
    }

    public static String normalizeFlagForStorage(String flag) {
        String f = normalize(flag);
        if ("n/a".equals(f)) return "N/A";
        return f;
    }
}
