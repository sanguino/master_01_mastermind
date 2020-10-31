package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.utils.WithConsoleView;

class StartView extends WithConsoleView {

    void interact(StartController startController) {
        MessageView.TITLE.writeln();
        new SecretCombinationView().writeln();
        startController.next();
    }
}
