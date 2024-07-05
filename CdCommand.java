package IO;

import java.io.File;

public class CdCommand extends Command{
    public CdCommand(){
        super("cd");
    }
    @Override
    public void action(String[] cmd) {
        if (cmd.length > 1) {
            // Kezelje a "cd .." parancsot a szülő könyvtárba lépéshez
            if ("..".equals(cmd[1])) {
                File parentDir = Main.wd.getParentFile();
                if (parentDir != null && parentDir.exists()) {
                    Main.wd = parentDir;
                    System.out.println("Moved to parent directory: " + Main.wd.getPath());
                } else {
                    System.out.println("No parent directory.");
                }
            } else {
                // Kezelje a normál könyvtár váltást
                File newDir = new File(Main.wd, cmd[1]);
                if (newDir.exists() && newDir.isDirectory()) {
                    Main.wd = newDir;
                    System.out.println("Changed directory to: " + Main.wd.getPath());
                } else {
                    System.out.println("Directory does not exist.");
                }
            }
        } else {
            System.out.println("No directory specified.");
        }
    }
}
