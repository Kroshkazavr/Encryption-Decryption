package encryptdecrypt;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Part for default values
        String mode = "enc";
        int key = 0;
        String data = "";
        String pathToFileIn = null;
        String pathToFileOut = null;

        // Part for arguments reading
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

        // Part for program's logic
        // 1. Enc -mode
        if (mode.matches("enc")) {
            if (pathToFileIn == null || !data.matches("")) {
                // 1. If there is no -in
                // 2.If there are both -data and -in arguments,
                // program prefers -data
                writeCipherText(pathToFileOut, enc(data, key));
            } else {
                // In other cases
                writeCipherText(pathToFileOut, enc(readFromFile(pathToFileIn), key));
            }
            //2. Dec -mode
        } else {
            if (pathToFileIn == null || !data.matches("")) {
                // 1. If there is no -in
                // 2.If there are both -data and -in arguments,
                // program prefers -data
                writeCipherText(pathToFileOut, dec(data, key));
            } else {
                // In other cases
                writeCipherText(pathToFileOut, dec(readFromFile(pathToFileIn), key));
            }
        }
    }

    /**
     * @param str cipher data for decryption
     * @param key key for decryption
     * @return decrypted text
     */
    private static String dec(String str, int key) {
        String text = "";
        int decryptionIndex;
        for (int i = 0; i < str.length(); i++) {
            decryptionIndex = (int) str.charAt(i) - key;
            text += String.valueOf((char) decryptionIndex);
        }
        return text;
    }

    /**
     * @param str text for encryption
     * @param key key for encryption
     * @return cipher data
     */
    private static String enc(String str, int key) {
        String cipherData = "";
        int encryptionIndex;
        for (int i = 0; i < str.length(); i++) {
            encryptionIndex = (int) str.charAt(i) + key;
            cipherData += String.valueOf(((char) encryptionIndex));
        }
        return cipherData;
    }

    /**
     * The method reads the text from input file
     *
     * @param pathToFileIn path to input file
     * @return string from input file
     */
    private static String readFromFile(String pathToFileIn) {
        File file = new File(pathToFileIn);
        String result = "";
        try (Scanner in = new Scanner(file)) {
            result = in.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("Error with input from file.");
        }
        return result;
    }

    /**
     * The method writs the text to output file and
     * if output file dos not exists the method create it
     *
     * @param pathToFileOut path to output file
     * @param text          string for output
     */
    private static void writeCipherText(String pathToFileOut, String text) {
        File file = new File(pathToFileOut);
        if (!file.exists() && pathToFileOut != null) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error. Can't create output file.");
            }
        }
        if (file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(text);
            } catch (IOException e) {
                System.out.println("Error with file writing.");
            }
        } else {
            System.out.println(text);
        }
    }
}

