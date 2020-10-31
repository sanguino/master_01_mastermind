package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.implementation.PlayControllerImplementation;
import usantatecla.mastermind.models.Result;


public class GetResultDispatcher extends Dispatcher {

    public GetResultDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        int i = this.tcpip.receiveInt();
        Result result = ((PlayControllerImplementation) this.acceptorController).getResult(i);
        this.tcpip.send(result.getBlacks());
        this.tcpip.send(result.getWhites());
    }

}
