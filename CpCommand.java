package IO;

import java.io.*;

public class CpCommand extends Command{
    public CpCommand() {
        super("cp");
    }
    @Override
    public void action(String[] cmd) {
        if (cmd.length > 2) {
            File sourceFile = new File(Main.wd, cmd[1]);
            File destinationFile = new File(Main.wd, cmd[2]);

            try (FileInputStream fis = new FileInputStream(sourceFile);
                 FileOutputStream fos = new FileOutputStream(destinationFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
                System.out.println("File copied successfully.");
            } catch (IOException e) {
                System.out.println("Error copying file: " + e.getMessage());
            }
        } else {
            System.out.println("Insufficient arguments. Usage: cp <source> <destination>");
        }
    }
    
}
