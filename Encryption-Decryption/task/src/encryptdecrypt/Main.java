package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toLowerCase();
        int key = in.nextInt();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.substring(i, i));
            if (str.substring(i, i + 1).matches("[a-z]")) {
                int encryptionIndex = alphabet.indexOf(str.substring(i, i + 1)) + key;
                while (encryptionIndex >= alphabet.length() - 1) {
                    encryptionIndex = encryptionIndex - 26;
                }
                System.out.print(alphabet.charAt(encryptionIndex));
            } else {
                System.out.print(str.substring(i, i + 1));
            }
        }
    }
}
