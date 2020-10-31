package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.implementation.PlayControllerImplementation;

public class GetProposeDispatcher extends Dispatcher {

    public GetProposeDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        int i = this.tcpip.receiveInt();
        String combination = ((PlayControllerImplementation)this.acceptorController).getProposedCombination(i).toString();
        for(int j = 0; j < combination.length(); j++) {
            this.tcpip.send(combination.charAt(j));
        }
    }

}
