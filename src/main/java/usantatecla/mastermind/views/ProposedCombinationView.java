package usantatecla.mastermind.views;

import usantatecla.utils.WithConsoleView;

public class ProposedCombinationView extends WithConsoleView {

    public String read() {
        MessageView.PROPOSED_COMBINATION.write();
        return this.console.readString();
    }

    public void write(String colors, int blacks, int whites) {
        MessageView.COLORS.write(colors);
        MessageView.RESULT.writeln(blacks, whites);
    }
}
