package sanguino.mastermind;

import java.util.Arrays;

public class SecretCombination extends Combination {

    public SecretCombination() {
        this.color = new Color[Combination.NUMBER_COLORS];
        int pos = 0;
        do {
            Color generated = Color.randomColor();
            if (!Arrays.stream(this.color).anyMatch(generated::equals)) {
                this.color[pos] = generated;
                pos++;
            }
        } while (pos < Combination.NUMBER_COLORS);
    }

    public Result check(ProposedCombination proposedCombination) {
        Success[] success = new Success[Combination.NUMBER_COLORS];
        for (int i = 0; i < Combination.NUMBER_COLORS; i++) {
            if (this.color[i] == proposedCombination.getColor(i)) {
                success[i] = Success.BLACK;
            } else if (Arrays.stream(this.color).anyMatch(proposedCombination.getColor(i)::equals)) {
                success[i] = Success.WHITE;
            } else {
                success[i] = Success.NULL_SUCCESS;
            }
        }
        return new Result(success);
    }
}
