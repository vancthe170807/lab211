package util;

import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * Centralized validation logic for candidate data
 */
public class Validator {

    /**
     * Validate birth date (1900 to current year)
     */
    public static boolean isValidBirthDate (int year) {
        int currentYear;

        currentYear = Calendar.getInstance ().get (Calendar.YEAR);
        return year >= 1900 && year <= currentYear;
    }

    /**
     * Validate phone number (minimum 10 digits)
     */
    public static boolean isValidPhone (String phone) {
        return phone != null && phone.matches (Constants.PHONE_PATTERN);
    }

    /**
     * Validate email format
     */
    public static boolean isValidEmail (String email) {
        return email != null &&
                Pattern.compile (Constants.EMAIL_PATTERN).matcher (email).matches ();
    }

    /**
     * Validate experience years (0-100)
     */
    public static boolean isValidExperience (int years) {
        return years >= 0 && years <= 100;
    }

    /**
     * Validate graduation rank
     */
    public static boolean isValidGraduationRank (String rank) {
        // Check if rank is null to avoid NullPointerException
        if (rank == null) {
            return false;
        }

        // Loop through all valid graduation ranks
        for (String validRank : Constants.GRADUATION_RANKS_ARRAY) {
            // Compare case-insensitively to allow "excellence", "GOOD", etc.
            if (validRank.equalsIgnoreCase (rank)) {
                return true; // Found a match, rank is valid
            }
        }

        // No match found, rank is invalid
        return false;
    }

    /**
     * Validate candidate type
     */
    public static boolean isValidCandidateType (int type) {
        return type >= 0 && type <= 2;
    }

    /**
     * Validate non-empty string
     */
    public static boolean isNotEmpty (String str) {
        return str != null && !str.trim ().isEmpty ();
    }

    /**
     * Get current year
     */
    public static int getCurrentYear () {
        return Calendar.getInstance ().get (Calendar.YEAR);
    }
}
