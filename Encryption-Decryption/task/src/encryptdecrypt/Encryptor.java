package encryptdecrypt;

public class Encryptor {

    /**
     * @param str text for encryption
     * @param key key for encryption
     * @return cipher data
     */
    public static String enc(String str, int key) {
        StringBuilder cipherData = new StringBuilder();
        int encryptionIndex;
        for (int i = 0; i < str.length(); i++) {
            encryptionIndex = (int) str.charAt(i) + key;
            cipherData.append((char) encryptionIndex);
        }
        return cipherData.toString();
    }

}
