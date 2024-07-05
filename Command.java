package IO;

import java.util.ArrayList;

public abstract class Command {
    private String name;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void action(String[] cmd);
}
