package frc.robot;

import frc.robot.commands.pneumatics.ShiftDown;
import frc.robot.commands.pneumatics.ShiftUp;
import frc.robot.lib.joystick.XboxController;

public final class OI {
	private static final int XBOX_PORT_1 = 0;
	private static final int XBOX_PORT_2 = 1;

	private XboxController xbox1 = new XboxController(XBOX_PORT_1);
	private XboxController xbox2 = new XboxController(XBOX_PORT_2);

	public OI() {
		xbox1.leftBumper.whenPressed(new ShiftUp());
		xbox1.leftBumper.whenReleased(new ShiftDown());
	}

	public void check() {
		xbox1.check();
		xbox2.check();
	}

	public XboxController getXboxController(){
		return xbox1;
	}

	public XboxController getXboxController2(){
		return xbox2;
	}
}
