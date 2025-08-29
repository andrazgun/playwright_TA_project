package support;

public class StringUtils {

    public static String replaceLineWithSpace(final String input) {
        if (input == null) {
            return "";
        }
        return input.replace('-', ' ');
    }
}
