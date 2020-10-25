package usantatecla.mastermind.views.console;

import usantatecla.utils.Console;

enum MessageView {
    ATTEMPTS("#attempts attempt(s): "),
    SECRET("*"),
    RESUME("Do you want to continue"),
    RESULT(" --> #blacks blacks and #whites whites"),
    PROPOSE_COMBINATION("Propose a combination: "),
    PROPOSE_COMMAND("Propose a combination"),
    UNDO_COMMAND("Undo previous combination"),
    REDO_COMMAND("Redo previous combination"),
    TITLE("----- MASTERMIND -----"),
    WINNER("You've won!!! ;-)"),
    LOOSER("You've lost!!! :-(");

    private String message;

    private Console console;

    private MessageView(String message) {
        this.console = new Console();
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    void write() {
        this.console.write(this.message);
    }

    void writeln() {
        this.console.writeln(this.message);
    }

    void writeln(int attempts) {
        this.console.writeln(this.message.replaceAll("#attempts", "" + attempts));
    }

    void writeln(int blacks, int whites) {
        this.console.writeln(this.message.replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
    }

}
