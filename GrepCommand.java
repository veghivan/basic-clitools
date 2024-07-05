package IO;

import java.io.File;
import java.util.Scanner;

public class GrepCommand extends Command {
    public GrepCommand() {
        super("grep");
    }

    @Override
    public void action(String[] cmd) {
        if (cmd.length > 2) {
            File file = new File(Main.wd, cmd[2]);
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    String pattern = ".*" + cmd[1] + ".*";
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.matches(pattern)) {
                            System.out.println(line);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            } else {
                System.out.println("File does not exist.");
            }
        } else {
            System.out.println("Insufficient arguments. Usage: grep <pattern> <file>");
        }
    }
}
