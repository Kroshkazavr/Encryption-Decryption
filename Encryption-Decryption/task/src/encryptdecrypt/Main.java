package encryptdecrypt;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String pathToFileIn = null;
        String pathToFileOut = null;
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
            if (args[i].equals("-in")) {
                pathToFileIn = args[i + 1];
            }
            if (args[i].equals("-out")) {
                pathToFileOut = args[i + 1];
            }
        }

//        if (mode.matches("enc")) {
//            enc(data, key);
//        } else {
//            dec(data, key);
//        }
    }

    private static String dec(String str, int key) {
        String text = "";
        int decryptionIndex;
        for (int i = 0; i < str.length(); i++) {
            decryptionIndex = (int) str.charAt(i) - key;
            text = String.valueOf(+(char) decryptionIndex);
        }
        return text;
    }

    private static String enc(String str, int key) {
        String cipherData = "";
        int encryptionIndex;
        for (int i = 0; i < str.length(); i++) {
            encryptionIndex = (int) str.charAt(i) + key;
            cipherData = String.valueOf(((char) encryptionIndex));
        }
        return cipherData;
    }

    private static String readFromFile(String pathToFileIn)
            throws FileNotFoundException {
        File file = new File(pathToFileIn);
        Scanner in = new Scanner(file);
        return in.nextLine();
    }

    private static void writeCipherText(String pathToFileOut, String text, int key)
            throws IOException {
        File file = new File(pathToFileOut);
        if (file.exists()) {
            FileWriter writer = new FileWriter(file);
            writer.write(dec(text, key));
        } else {
            System.out.println(dec(text, key));
        }
    }
}
