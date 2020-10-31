package usantatecla.mastermind.distributed.dispatchers;

public enum FrameType {
    GET_STATE,
    NEXT_STATE,
    UNDO,
    REDO,
    ADD_PROPOSE_COMBINATION,
    GET_PROPOSE_COMBINATION,
    RESULT,
    ATTEMPTS,
    WINNER,
    LOOSER,
    REDOABLE,
    UNDOABLE,
    RESUME,
    CLOSE;


    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}
