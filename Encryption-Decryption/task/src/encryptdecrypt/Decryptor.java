package encryptdecrypt;

public class Decryptor {

    /**
     * @param str cipher data for decryption
     * @param key key for decryption
     * @return decrypted text
     */
    public static String dec(String str, int key) {
        StringBuilder text = new StringBuilder();
        int decryptionIndex;
        for (int i = 0; i < str.length(); i++) {
            decryptionIndex = (int) str.charAt(i) - key;
            text.append((char) decryptionIndex);
        }
        return text.toString();
    }
}

