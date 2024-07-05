package IO;

import java.io.*;

public class CatCommand extends Command{
    public CatCommand() {
        super("cat");
    }

    @Override
    public void action(String[] cmd) {
        if (cmd.length > 1) {
            File file = new File(Main.wd, cmd[1]);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file specified. Usage: cat <file>");
        }
    }
}
