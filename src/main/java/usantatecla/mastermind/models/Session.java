package usantatecla.mastermind.models;

public class Session {

    private Game game;
    private State state;
    private ProposedRegistry registry;

    public Session() {
        this.game = new Game();
        this.state = new State();
        this.registry = new ProposedRegistry(this.game);
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public void nextState() {
        this.state.next();
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.game.addProposedCombination(proposedCombination);
        this.registry.registry();
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public ProposedCombination getProposedCombination(int i) {
        return this.game.getProposedCombination(i);
    }

    public Result getResult(int i) {
        return this.game.getResult(i);
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public void reset() {
        this.game.clear();
        this.state.reset();
        this.registry.reset();
    }

    public void undo() {
        this.registry.undo();
    }

    public void redo() {
        this.registry.redo();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

}
