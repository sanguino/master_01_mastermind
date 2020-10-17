package usantatecla.mastermind;

import usantatecla.mastermind.controllers.ProposeController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.views.console.View;

public class ConsoleMastermind extends Mastermind{

	@Override
	protected View createView(ProposeController proposeController, ResumeController resumeController) {
		return new View(proposeController, resumeController);
	}

	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}	

}
