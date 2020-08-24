package encryptdecrypt;

public interface ConversionMethod {

    final static String ALPHABET_UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static String ALPHABET_LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";

    static String convert(String algorithm, String data, int key) {
        String resultStr = "";
        if (algorithm.equalsIgnoreCase("shift")) {
            resultStr = shiftMethod(data, key);
        } else if (algorithm.equalsIgnoreCase("unicode")) {
            resultStr = unicodeMethod(data, key);
        }
        return resultStr;
    }

    static String unicodeMethod(String data, int key) {
        return null;
    }

    static String shiftMethod(String data, int key) {
        return null;
    }
}

