package IO;

import java.io.File;

public class LengthCommand extends Command {
    public LengthCommand() {
        super("length");
    }

    @Override
    public void action(String[] cmd) {
        if (cmd.length > 1) {
            File file = new File(Main.wd, cmd[1]);
            if (file.exists()) {
                System.out.println("File length: " + file.length() + " bytes");
            } else {
                System.out.println("File does not exist.");
            }
        } else {
            System.out.println("No file specified. Usage: length <file>");
        }
    }
}
