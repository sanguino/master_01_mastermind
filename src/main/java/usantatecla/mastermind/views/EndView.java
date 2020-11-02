package usantatecla.mastermind.views;

public class EndView {

    public void writeWinner() {
        MessageView.WINNER.writeln();
    }

    public void writeLooser() {
        MessageView.LOOSER.writeln();
    }
}

