package IO;

import java.io.File;

public class LsCommand extends Command{
    public LsCommand(){
        super("ls");
    }
    @Override
    public void action(String[] cmd) {
        boolean detailed = cmd.length > 1 && "-l".equals(cmd[1]);
        File[] files = Main.wd.listFiles();

        if (files == null) {
            System.out.println("No files found.");
            return;
        }

        for (File file : files) {
            if (detailed) {
                // Méret megjelenítése byte-ban, és fájl típusának jelzése (d: könyvtár, f: fájl)
                String type = file.isDirectory() ? "d" : "f";
                System.out.println(String.format("%s - %s - %d bytes", file.getName(), type, file.length()));
            } else {
                // Alapvető lista, csak a nevekkel
                System.out.println(file.getName());
            }
        }
    }
}
