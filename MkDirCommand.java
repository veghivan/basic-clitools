package IO;

import java.io.File;

public class MkDirCommand extends Command {
    public MkDirCommand() {
        super("mkdir");
    }

    @Override
    public void action(String[] cmd) {
        if (cmd.length > 1) {
            File newDir = new File(Main.wd, cmd[1]);
            if (!newDir.exists()) {
                boolean created = newDir.mkdir();
                if (created) {
                    System.out.println("Dir succesfully created.");
                } else
                    System.out.println("Failed o create Dir.");
            } else
                System.out.println("Dir with name " + cmd[1] + " already exsits.");
        } else
            System.out.println("No file specified. (example: mkdir mydir) -> makes a mydir named directory.");
    }
}
