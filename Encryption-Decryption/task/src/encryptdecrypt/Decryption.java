package encryptdecrypt;

import static encryptdecrypt.Constants.ALPHABET_LOWER_CASE;
import static encryptdecrypt.Constants.ALPHABET_UPPER_CASE;

public class Decryption {

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
        StringBuilder text = new StringBuilder();
        int decryptionIndex;
        for (int i = 0; i < str.length(); i++) {
            decryptionIndex = (int) str.charAt(i) - key;
            text.append((char) decryptionIndex);
        }
        return text.toString();
    }

    public static String shiftMethod(String data, int key) {
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            if (data.substring(i, i + 1).matches("[A-Z]")) {
                int decryptionIndex = ALPHABET_UPPER_CASE.indexOf(data.substring(i, i + 1)) - key;
                while (decryptionIndex < 0) {
                    decryptionIndex = decryptionIndex + 26;
                }
                resultString.append(ALPHABET_UPPER_CASE.charAt(decryptionIndex));
            } else if (data.substring(i, i + 1).matches("[a-z]")) {
                int decryptionIndex = ALPHABET_LOWER_CASE.indexOf(data.substring(i, i + 1)) - key;
                while (decryptionIndex < 0) {
                    decryptionIndex = decryptionIndex + 26;
                }
                resultString.append(ALPHABET_LOWER_CASE.charAt(decryptionIndex));
            } else {
                resultString.append(data.charAt(i));
            }
        }
        return resultString.toString();
    }
}

