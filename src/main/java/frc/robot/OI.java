package frc.robot;

import frc.robot.commands.pneumatics.ShiftDown;
import frc.robot.commands.pneumatics.ShiftUp;
import frc.robot.commands.pneumatics.puncher.PunchHatch;
import frc.robot.commands.pneumatics.tilter.ArmClose;
import frc.robot.commands.pneumatics.tilter.ArmOpen;
import frc.robot.lib.joystick.XboxController;

public final class OI {
	private static final int XBOX_PORT_1 = 0;

	private XboxController xbox1 = new XboxController(XBOX_PORT_1);

	public OI() {
		xbox1.leftBumper.whenPressed(new ShiftUp());
		xbox1.leftBumper.whenReleased(new ShiftDown());
		xbox1.a.whenPressed(new PunchHatch());
		xbox1.b.whenPressed(new ArmOpen());
		xbox1.b.whenReleased(new ArmClose());
	}

	public void check() {
		xbox1.check();
	}

	public XboxController getXboxController(){
		return xbox1;
	}
}
