package common.enums;

public enum Argument {
    YES("YES"),
    NO("NO"),
    GO("GO"),
    HELP("HELP"),
    LOOK("LOOK"),
    ATTACK("ATTACK"),
    TAKE("TAKE"),
    USE("USE"),
    QUIT("QUIT");

    private String command;

    public String getCommand() {
        return this.command;
    }

    Argument(String command) {
        this.command = command;
    }
}
