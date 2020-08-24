package encryptdecrypt;

public class Decryptor implements ConversionMethod {

//    @Override
//    public String convert(String algorithm, String data, int key) {
//        String resultStr = "";
//        if (algorithm.equalsIgnoreCase("shift")) {
//            resultStr = decShift(data, key);
//        } else if (algorithm.equalsIgnoreCase("unicode")) {
//            resultStr = decUnicode(data, key);
//        }
//        return resultStr;
//    }

    /**
     * @param str cipher data for decryption
     * @param key key for decryption
     * @return decrypted text
     */
    public String shiftMethod(String str, int key) {
        StringBuilder text = new StringBuilder();
        int decryptionIndex;
        for (int i = 0; i < str.length(); i++) {
            decryptionIndex = (int) str.charAt(i) - key;
            text.append((char) decryptionIndex);
        }
        return text.toString();
    }

    private String unicodeMethod(String data, int key) {
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            if (data.substring(i, i + 1).matches("[:upper:]")) {
                int decryptionIndex = ALPHABET_UPPER_CASE.indexOf(data.substring(i, i + 1)) - key;
                while (decryptionIndex < 0) {
                    decryptionIndex = decryptionIndex + 26;
                }
                resultString.append(ALPHABET_UPPER_CASE.charAt(decryptionIndex));
            } else if (data.substring(i, i + 1).matches("[:lower:]")) {
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

