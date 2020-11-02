package usantatecla.mastermind.views;

import usantatecla.utils.WithConsoleView;

public class AttempsView extends WithConsoleView {

    public void writeln(int attempts) {
        MessageView.ATTEMPTS.writeln(attempts);
    }
}
