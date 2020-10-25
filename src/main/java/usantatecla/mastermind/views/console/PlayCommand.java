package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.Command;

public abstract class PlayCommand extends Command {

    protected PlayController playController;

    protected PlayCommand(String title, PlayController playController) {
        super(title);
        this.playController = playController;
    }

}
