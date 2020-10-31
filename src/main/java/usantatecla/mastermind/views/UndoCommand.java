package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;

public class UndoCommand extends PlayCommand {

    public UndoCommand(PlayController playController) {
        super(MessageView.UNDO_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        this.playController.undo();
        new AttemptsView().write(playController);
    }

    @Override
    protected boolean isActive() {
        return this.playController.undoable();
    }

}
