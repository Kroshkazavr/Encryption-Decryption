package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Request {

    private Converter converter = new Converter();
    private String pathToFileIn = null;
    private String pathToFileOut = null;

    public Request(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                this.converter.setMode(args[i + 1]);
            }
            if (args[i].equals("-alg")) {
                this.converter.setAlgorithm(args[i + 1]);
            }
            if (args[i].equals("-key")) {
                this.converter.setKey(Integer.parseInt(args[i + 1]));
            }
            if (args[i].equals("-data")) {
                this.converter.setData(args[i + 1]);
            }
            if (args[i].equals("-in")) {
                this.pathToFileIn = args[i + 1];
            }
            if (args[i].equals("-out")) {
                this.pathToFileOut = args[i + 1];
            }
        }
    }

    public void run(Request request) {
        readData();
        getResult();
        outputResult();
    }

    private void getResult() {
        this.converter.convert();
    }

    private void readData() {
        if ("".equalsIgnoreCase(this.converter.getData())) {
            File file = new File(this.getPathToFileIn());
            try (Scanner in = new Scanner(file)) {
                this.converter.setData(in.nextLine());
            } catch (FileNotFoundException e) {
                System.out.println("Error with input from file.");
            }
        }
    }

    private void outputResult() {
        File file = new File(this.getPathToFileOut());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error. Can't create output file.");
            }
        }
        if (file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(this.converter.getResultData());
            } catch (IOException e) {
                System.out.println("Error with file writing.");
            }
        } else {
            System.out.println(this.converter.getResultData());
        }
    }

    public String getPathToFileIn() {
        return pathToFileIn;
    }

    public String getPathToFileOut() {
        return pathToFileOut;
    }

    public Converter getConverter() {
        return converter;
    }
}

