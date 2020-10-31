package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.implementation.LogicImplementation;
import usantatecla.mastermind.distributed.dispatchers.*;

public class LogicImplementationServer extends LogicImplementation {

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.GET_STATE, new GetStateDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.NEXT_STATE, new NextStateDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.ADD_PROPOSE_COMBINATION, new AddProposeDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_PROPOSE_COMBINATION, new GetProposeDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.RESULT, new GetResultDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.ATTEMPTS, new AttempsDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.WINNER, new WinnerDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.LOOSER, new LooserDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.RESUME, new ResumeDispatcher(this.resumeControllerImplementation));
    }

}
