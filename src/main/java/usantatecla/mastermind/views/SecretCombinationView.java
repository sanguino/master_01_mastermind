package usantatecla.mastermind.views;

import usantatecla.utils.WithConsoleView;

public class SecretCombinationView extends WithConsoleView {

    public void writeln(int width) {
        for (int i = 0; i < width; i++) {
            MessageView.SECRET.write();
        }
        this.console.writeln();
    }

}
