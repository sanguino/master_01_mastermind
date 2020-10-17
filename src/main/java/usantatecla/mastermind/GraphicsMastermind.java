package usantatecla.mastermind;

import usantatecla.mastermind.controllers.ProposeController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.views.graphics.View;

public class GraphicsMastermind extends Mastermind{

	@Override
	protected View createView(ProposeController proposeController, ResumeController resumeController) {
		return new View(proposeController, resumeController);
	}

	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}

}
