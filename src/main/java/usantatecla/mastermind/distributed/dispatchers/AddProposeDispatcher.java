package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.implementation.PlayControllerImplementation;
import usantatecla.mastermind.models.Color;
import usantatecla.mastermind.models.ProposedCombination;

public class AddProposeDispatcher extends Dispatcher {

    public AddProposeDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        ProposedCombination proposedCombination = new ProposedCombination();
        for (int j = 0; j < ProposedCombination.getWidth(); j++) {
            char character = this.tcpip.receiveChar();
            proposedCombination.getColors().add(Color.getColor(character));
        }
        ((PlayControllerImplementation) this.acceptorController).addProposedCombination(proposedCombination);
    }

}
