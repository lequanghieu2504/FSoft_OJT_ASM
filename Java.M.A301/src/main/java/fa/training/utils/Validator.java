package fa.training.utils;


import java.util.regex.Pattern;

public class Validator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^0\\d{9}$");

    public static boolean isValidMark(double mark) {
        return mark >= 0 && mark <= 10;
    }

    public static boolean isValidGender(String gender) {
        return gender.equals("Male") || gender.equals("Female");
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }
}
