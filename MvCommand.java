package IO;

import java.io.File;

public class MvCommand extends Command {
    public MvCommand() {
        super("mv");
    }

    public void action(String[] cmd) {
        if (cmd.length > 2 && cmd.length < 4) {
            File original = new File(Main.wd, cmd[1]);
            File newfile = new File(Main.wd, cmd[2]);
            if (original.exists()) {
                if (!newfile.exists()) {
                    boolean success = original.renameTo(newfile);
                    if (success) {
                        System.out.println("File renaming was successfull.");
                    } else
                        System.out.println("Failed to rename the file.");
                } else
                    System.out.println("Failed to rename file: Specified new filename is already taken.");
            } else
                System.out.println("Original file does not exists.");
        } else
            System.out.println("No file name specified or too many arguments. (example: mv file1 file2) -> renames file1 to file2");
    }
}
