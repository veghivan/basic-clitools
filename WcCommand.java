package IO;

import java.io.File;
import java.util.Scanner;

public class WcCommand extends Command {
    public WcCommand() {
        super("wc");
    }

    @Override
    public void action(String[] cmd) {
        if (cmd.length > 1) {
            File file = new File(Main.wd, cmd[1]);
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    int lines = 0, words = 0, chars = 0;
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        lines++;
                        words += line.split("\\s+").length;
                        chars += line.length();
                    }
                    System.out.printf("Lines: %d, Words: %d, Characters: %d%n", lines, words, chars);
                } catch (Exception e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            } else {
                System.out.println("File does not exist.");
            }
        } else {
            System.out.println("No file specified. Usage: wc <file>");
        }
    }
}
