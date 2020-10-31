package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ProposeController;
import usantatecla.mastermind.controllers.RedoController;
import usantatecla.mastermind.controllers.UndoController;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.models.Session;

public class PlayControllerImplementation extends PlayController {

    private ProposeController proposeController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayControllerImplementation(Session session) {
        super(session);
        this.proposeController = new ProposeController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }

    @Override
    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposeController.addProposedCombination(proposedCombination);
    }

    @Override
    public int getAttempts() {
        return this.proposeController.getAttempts();
    }

    @Override
    public ProposedCombination getProposedCombination(int i) {
        return this.proposeController.getProposedCombination(i);
    }

    @Override
    public Result getResult(int i) {
        return this.proposeController.getResult(i);
    }

    @Override
    public boolean isWinner() {
        return this.proposeController.isWinner();
    }

    @Override
    public boolean isLooser() {
        return this.proposeController.isLooser();
    }

    @Override
    public void undo() {
        this.undoController.undo();
    }

    @Override
    public void redo() {
        this.redoController.redo();
    }

    @Override
    public boolean undoable() {
        return this.undoController.undoable();
    }

    @Override
    public boolean redoable() {
        return this.redoController.redoable();
    }

}
