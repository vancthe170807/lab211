package util;

import java.util.Calendar;

/**
 * Date utility methods
 */
public class DateUtil {

    /**
     * Get current year
     */
    public static int getCurrentYear () {
        return Calendar.getInstance ().get (Calendar.YEAR);
    }

    /**
     * Validate year range
     */
    public static boolean isValidYear (int year, int min, int max) {
        return year >= min && year <= max;
    }
}
