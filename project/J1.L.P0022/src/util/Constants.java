package util;

/**
 * Global constants for the application
 */
public class Constants {

    // Regex pattern for email validation
    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    // Regex pattern for phone validation
    public static final String PHONE_PATTERN = "^\\d{10,}$";

    // Valid graduation ranks
    public static final String[] GRADUATION_RANKS_ARRAY = {
        "Excellence", "Good", "Fair", "Poor"
    };
}
