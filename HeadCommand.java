package IO;

import java.io.File;
import java.util.Scanner;

public class HeadCommand extends Command {
    public HeadCommand() {
        super("head");
    }

    @Override
    public void action(String[] cmd) {
        int linesToRead = 10;  // Default line count
        String filePath;

        if (cmd.length > 1 && cmd[1].equals("-n")) {
            if (cmd.length > 3) {
                linesToRead = Integer.parseInt(cmd[2]);
                filePath = cmd[3];
            } else {
                System.out.println("Insufficient arguments. Usage: head -n <n> <file>");
                return;
            }
        } else if (cmd.length > 1) {
            filePath = cmd[1];
        } else {
            System.out.println("Usage: head [-n <n>] <file>");
            return;
        }

        File file = new File(Main.wd, filePath);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                int currentLine = 0;
                while (scanner.hasNextLine() && currentLine < linesToRead) {
                    System.out.println(scanner.nextLine());
                    currentLine++;
                }
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}
