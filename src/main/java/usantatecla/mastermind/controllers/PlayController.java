package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.models.Session;

public class PlayController extends AcceptorController {

    private ProposeController proposeController;
    private UndoController undoController;
    private RedoController redoController;


    public PlayController(Session session) {

        super(session);
        this.proposeController = new ProposeController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);


    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposeController.addProposedCombination(proposedCombination);
    }

    public int getAttempts() {
        return this.proposeController.getAttempts();
    }

    public ProposedCombination getProposedCombination(int i) {
        return this.proposeController.getProposedCombination(i);
    }

    public Result getResult(int i) {
        return this.proposeController.getResult(i);
    }

    public boolean isWinner() {
        return this.proposeController.isWinner();
    }

    public boolean isLooser() {
        return this.proposeController.isLooser();
    }

    public void undo() {
        this.undoController.undo();
    }

    public void redo() {
        this.redoController.redo();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public boolean undoable() {
        return this.undoController.undoable();
    }

    public boolean redoable() {
        return this.redoController.redoable();
    }

}
