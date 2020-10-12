package sanguino.mastermind.views;

import sanguino.utils.YesNoDialog;

class ResumeView {

    boolean interact() {
        return new YesNoDialog().read(Message.RESUME.toString());
    }

}
