package sanguino.mastermind.models;

import java.util.Arrays;

public class Result {
    Success[] success;

    public Result(Success[] success) {
        this.success = success;
    }

    public long getBlacks() {
        return Arrays.stream(this.success).filter(Success.BLACK::equals).count();
    }

    public long getWhites() {
        return Arrays.stream(this.success).filter(Success.WHITE::equals).count();
    }

    public boolean isWinner() {
        return Arrays.stream(this.success).allMatch(Success.BLACK::equals);
    }

}
