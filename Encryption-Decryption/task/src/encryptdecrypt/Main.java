package encryptdecrypt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine().toLowerCase();
        String str = in.nextLine();
        int key = in.nextInt();
        if (operation.matches("enc")) {
            enc(str, key);
        } else {
            dec(str, key);
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
