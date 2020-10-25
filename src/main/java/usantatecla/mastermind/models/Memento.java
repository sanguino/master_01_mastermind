package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class Memento {

    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;
    private int attempts;

    public Memento(List<ProposedCombination> proposedCombinations, List<Result> results, int attempts) {
        this.proposedCombinations = new ArrayList<>(proposedCombinations);
        this.results = new ArrayList<>(results);
        this.attempts = attempts;
    }

    public List<ProposedCombination> getProposedCombinations() {
        return new ArrayList<>(this.proposedCombinations);
    }

    public List<Result> getResults() {
        return new ArrayList<>(this.results);
    }

    public int getAttempts() {
        return this.attempts;
    }

}
