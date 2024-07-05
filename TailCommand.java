package IO;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class TailCommand extends Command {
    public TailCommand() {
        super("tail");
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
                System.out.println("Insufficient arguments. Usage: tail -n <n> <file>");
                return;
            }
        } else if (cmd.length > 1) {
            filePath = cmd[1];
        } else {
            System.out.println("Usage: tail [-n <n>] <file>");
            return;
        }

        File file = new File(Main.wd, filePath);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                LinkedList<String> lines = new LinkedList<>();
                while (scanner.hasNextLine()) {
                    if (lines.size() == linesToRead) {
                        lines.removeFirst();
                    }
                    lines.addLast(scanner.nextLine());
                }
                lines.forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}
