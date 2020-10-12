package sanguino.mastermind.views;

import sanguino.mastermind.models.Game;

public class View {

    private Game game;
    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public View(Game game) {
        this.game = game;
        this.startView = new StartView(this.game);
        this.playView = new PlayView(this.game);
        this.resumeView = new ResumeView();
    }

    public void interact() {
        do {
            this.startView.interact();
            this.playView.interact();
        } while (this.resumeView.interact());
    }

}