package IO;

import java.io.File;

public class PwdCommand extends Command {
    public PwdCommand() {
        super("pwd");
    }

    @Override
    public void action(String[] cmd) {

        File[] files = Main.wd.listFiles();
        int numberOfFiles = files != null ? files.length : 0;
        System.out.println("Current working dir: " + Main.wd + "\nSub dirs: " + numberOfFiles);
    }
}
