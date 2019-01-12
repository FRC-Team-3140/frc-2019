package frc.robot;

import frc.robot.commands.pneumatics.ShiftDown;
import frc.robot.commands.pneumatics.ShiftUp;
import frc.robot.lib.joystick.XboxController;

public class OI {

    private XboxController xbox1 = new XboxController(Config.XBOX_1);

    public OI() {
        xbox1.leftBumper.whenPressed(new ShiftUp());
        xbox1.leftBumper.whenReleased(new ShiftDown());
    }

    public void check() {
        xbox1.check();
	}

	public XboxController getXboxController(){
		return xbox1;
	}
}
