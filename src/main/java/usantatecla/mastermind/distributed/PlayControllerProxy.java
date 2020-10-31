package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.models.Color;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.models.Session;
import usantatecla.utils.TCPIP;

public class PlayControllerProxy extends PlayController {

    private TCPIP tcpip;

    public PlayControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.tcpip.send(FrameType.ADD_PROPOSE_COMBINATION.name());
        String combination = proposedCombination.toString();
        for (int i = 0; i < combination.length(); i++) {
            this.tcpip.send(combination.charAt(i));
        }
    }

    @Override
    public int getAttempts() {
        this.tcpip.send(FrameType.ATTEMPTS.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public ProposedCombination getProposedCombination(int i) {
        this.tcpip.send(FrameType.GET_PROPOSE_COMBINATION.name());
        this.tcpip.send(i);
        ProposedCombination proposedCombination = new ProposedCombination();
        for (int j = 0; j < ProposedCombination.getWidth(); j++) {
            proposedCombination.getColors().add(Color.getColor(this.tcpip.receiveChar()));
        }
        return proposedCombination;
    }

    @Override
    public Result getResult(int i) {
        this.tcpip.send(FrameType.RESULT.name());
        this.tcpip.send(i);
        return new Result(this.tcpip.receiveInt(), this.tcpip.receiveInt());
    }

    @Override
    public boolean isWinner() {
        this.tcpip.send(FrameType.WINNER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean isLooser() {
        this.tcpip.send(FrameType.LOOSER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public void undo() {
        this.tcpip.send(FrameType.UNDO.name());
    }

    @Override
    public void redo() {
        this.tcpip.send(FrameType.REDO.name());
    }

    @Override
    public boolean undoable() {
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean redoable() {
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

}
