package sanguino.mastermind;

import java.util.Arrays;

public class Result {
    Success[] success;

    public Result(Success[] success) {
        this.success = success;
    }

    private long getBlacks() {
        return Arrays.stream(this.success).filter(Success.BLACK::equals).count();
    }

    private long getWhites() {
        return Arrays.stream(this.success).filter(Success.WHITE::equals).count();
    }

    public boolean isWinner() {
        return Arrays.stream(this.success).allMatch(Success.BLACK::equals);
    }

    @Override
    public String toString() {
        return Long.toString(this.getBlacks()) + Message.PART_BLACKS + Long.toString(this.getWhites()) + Message.PART_WHITES;
    }
}
