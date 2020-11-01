package usantatecla.mastermind.views;

import usantatecla.utils.Console;

public enum MessageView {
    ATTEMPTS("#attempts attempt(s): "),
    SECRET("*"),
    RESUME("Do you want to continue"),
    RESULT(" --> #blacks blacks and #whites whites"),
    PROPOSED_COMBINATION("Propose a combination: "),
    TITLE("----- MASTERMIND -----"),
    WINNER("You've won!!! ;-)"),
    LOOSER("You've lost!!! :-("),
    COLORS("+ "),
    ERROR("Error: ");

    private String message;

    private Console console;

    private MessageView(String message) {
        this.console = new Console();
        this.message = message;
    }

    public void write() {
        this.console.write(this.message);
    }

    public void writeln() {
        this.console.writeln(this.message);
    }

    public void write(String colors) {
        assert this == MessageView.COLORS;
        this.console.write(this.message + colors);
    }

    public void writeln(String error) {
        assert this == MessageView.ERROR;
        this.console.writeln(this.message + error);
    }

    public void writeln(int attempts) {
        assert this == MessageView.ATTEMPTS;
        this.console.writeln();
        this.console.writeln(this.message.replaceAll("#attempts", "" + attempts));
    }

    public void writeln(int blacks, int whites) {
        assert this == MessageView.RESULT;
        this.console.writeln(this.message.replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
    }

}
