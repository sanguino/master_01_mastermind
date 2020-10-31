package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.models.Session;
import usantatecla.utils.TCPIP;

public class ResumeControllerProxy extends ResumeController {

    private TCPIP tcpip;

    public ResumeControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void resume() {
        this.tcpip.send(FrameType.RESUME.name());
    }

}
