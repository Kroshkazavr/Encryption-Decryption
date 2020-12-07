package encryptdecrypt;

import static encryptdecrypt.Constants.ALPHABET_LOWER_CASE;
import static encryptdecrypt.Constants.ALPHABET_UPPER_CASE;

public class Encryption {

    public static String transform(String data, String algorithm, int key) {
        String resultStr = "";
        if (algorithm.equalsIgnoreCase("shift")) {
            resultStr = shiftMethod(data, key);
        } else if (algorithm.equalsIgnoreCase("unicode")) {
            resultStr = unicodeMethod(data, key);
        }
        return resultStr;
    }

    public static String unicodeMethod(String str, int key) {
        StringBuilder cipherData = new StringBuilder();
        int encryptionIndex;
        for (int i = 0; i < str.length(); i++) {
            encryptionIndex = (int) str.charAt(i) + key;
            cipherData.append((char) encryptionIndex);
        }
        return cipherData.toString();
    }

    public static String shiftMethod(String str, int key) {
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).matches("[A-Z]")) {
                int encryptionIndex = ALPHABET_UPPER_CASE.indexOf(str.substring(i, i + 1)) + key;
                while (encryptionIndex >= ALPHABET_UPPER_CASE.length() - 1) {
                    encryptionIndex = encryptionIndex - 26;
                }
                resultString.append(ALPHABET_UPPER_CASE.charAt(encryptionIndex));
            } else if (str.substring(i, i + 1).matches("[a-z]")) {
                int encryptionIndex = ALPHABET_LOWER_CASE.indexOf(str.substring(i, i + 1)) + key;
                while (encryptionIndex >= ALPHABET_LOWER_CASE.length() - 1) {
                    encryptionIndex = encryptionIndex - 26;
                }
                resultString.append(ALPHABET_LOWER_CASE.charAt(encryptionIndex));
            } else {
                resultString.append(str.charAt(i));
            }
        }
        return resultString.toString();
    }

}
