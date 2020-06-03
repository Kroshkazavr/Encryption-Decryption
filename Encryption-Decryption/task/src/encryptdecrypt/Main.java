package encryptdecrypt;


public class Main {

    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                data = args[i + 1];
            }
        }

        if (mode.matches("enc")) {
            enc(data, key);
        } else {
            dec(data, key);
        }
    }

    private static void dec(String str, int key) {
        for (int i = 0; i < str.length(); i++) {
            int decryptionIndex = (int) str.charAt(i) - key;
            System.out.print((char) decryptionIndex);
        }
    }

    private static void enc(String str, int key) {
        for (int i = 0; i < str.length(); i++) {
            int encryptionIndex = (int) str.charAt(i) + key;
            System.out.print((char) encryptionIndex);
        }
    }
}
