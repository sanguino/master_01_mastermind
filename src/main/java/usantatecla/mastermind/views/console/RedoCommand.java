package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;

public class RedoCommand extends PlayCommand {

    public RedoCommand(PlayController playController) {
        super(MessageView.REDO_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        this.playController.redo();
        new AttemptsView().write(playController);
    }

    @Override
    protected boolean isActive() {
        return this.playController.redoable();
    }

}
