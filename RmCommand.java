package IO;

import java.io.File;



public class RmCommand extends Command {
    public RmCommand() {
        super("rm");
    }

    public void action(String[] cmd) {
        if(cmd.length > 1){
            File file = new File(Main.wd, cmd[1]);
            if (file.exists() && file.isFile()){
                System.out.println("Are you sure you want to delete " + file.getName() + "? (yes/no)");
                String response = Main.scanner.nextLine();

                if(response.equalsIgnoreCase("yes")){
                    if(file.delete()){
                        System.out.println("File deleted succesfully.");
                    }else System.out.println("Failed to delete the file.");
                }else System.out.println("File deletion aborted.");
            }else System.out.println("Selected object is not a file or does not exist.");
        }else System.out.println("No file specified.");
    }
}
