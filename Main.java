package IO;   

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static File wd = new File(System.getProperty("user.dir"));
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Command> commands = new ArrayList<>();
        // használt commandok
        commands.add(new PwdCommand());
        commands.add(new LsCommand());
        commands.add(new CdCommand());
        commands.add(new RmCommand());
        commands.add(new MkDirCommand());
        commands.add(new MvCommand());
        commands.add(new CpCommand());
        commands.add(new TailCommand());
        commands.add(new CatCommand());
        commands.add(new LengthCommand());
        commands.add(new HeadCommand());
        commands.add(new WcCommand());
        commands.add(new GrepCommand());

        System.out.println("Started..." + "\n Type *exit* for closing");

        while (true) {
            String input = scanner.nextLine();
            // kilépés ága exitre
            if ("exit".equals(input.toLowerCase())) {
                break;
            }
            // végigiterálunk commands arraylisten keresve a parancsunk, ha megtaláljuk és
            // helyes lefuttatjuk
            String[] parts = input.split(" "); // pl: "ls l"(sor) -> ["ls", "l"](tömb)
            boolean found = false;
            for (Command command : commands) {
                if (command.getName().equals(parts[0])) {
                    command.action(parts);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Unknown command!");
            }

        }
        scanner.close();
    }
}
