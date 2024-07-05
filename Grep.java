package IO;

import java.io.*;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Grep {
    public static void main(String[] args) {
        String inputFilePath = null;
        String outputFilePath = null;
        String pattern = null;
        boolean gzipInput = false;
        boolean gzipOutput = false;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-p":
                    pattern = args[++i];
                    break;
                case "-i":
                    inputFilePath = args[++i];
                    break;
                case "-o":
                    outputFilePath = args[++i];
                    break;
                case "-gi":
                    gzipInput = true;
                    break;
                case "-go":
                    gzipOutput = true;
                    break;
                default:
                    System.out.println("Invalid argument: " + args[i]);
                    return;
            }
        }

        if (pattern == null) {
            System.out.println("No pattern specified. Usage: -p <pattern>");
            return;
        }

        try (Scanner scanner = createScanner(inputFilePath, gzipInput);
             Writer writer = createWriter(outputFilePath, gzipOutput)) {
            while (scanner != null && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.matches(".*" + pattern + ".*")) {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Scanner createScanner(String inputFilePath, boolean gzipInput) throws IOException {
        if (inputFilePath != null) {
            InputStream fileStream = new FileInputStream(inputFilePath);
            return new Scanner(gzipInput ? new GZIPInputStream(fileStream) : fileStream);
        }
        return new Scanner(System.in);
    }

    private static Writer createWriter(String outputFilePath, boolean gzipOutput) throws IOException {
        if (outputFilePath != null) {
            OutputStream fileStream = new FileOutputStream(outputFilePath);
            return new OutputStreamWriter(gzipOutput ? new GZIPOutputStream(fileStream) : fileStream);
        }
        return new OutputStreamWriter(System.out);
    }
}

