package support;

public class StringUtils {

    public static String replaceLineWithSpace(final String input) {
        if (input == null) {
            return "";
        }
        return input.replace('-', ' ');
    }

    /**
     * Cleans a price string by removing currency ("LEI"),
     * trimming spaces, and normalizing separators.
     * Example: "26,50 LEI" -> "26.50"
     */

    public static double priceStringToDouble(final String input) {
        if (input == null || input.isEmpty()) {
            return 0.0;
        }
        String cleaned = input.replace("LEI", "").trim();     // remove currency
        cleaned = cleaned.replace(".", "");                   // remove thousands separator
        cleaned = cleaned.replace(",", ".");                  // replace decimal comma with dot
        return Double.parseDouble(cleaned);
    }
}
