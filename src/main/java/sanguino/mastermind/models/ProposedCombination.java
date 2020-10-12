package sanguino.mastermind.models;

public class ProposedCombination extends Combination {
    private String combinationString;

    public ProposedCombination(String combinationString) {
        this.combinationString = combinationString;
        this.color = new Color[Combination.NUMBER_COLORS];
        for (int i = 0; i < Combination.NUMBER_COLORS; i++) {
            this.color[i] = Color.getFromValue(combinationString.charAt(i));
        }
    }

    public Color getColor(int i) {
        return this.color[i];
    }

    @Override
    public String toString() {
        return this.combinationString;
    }
}
