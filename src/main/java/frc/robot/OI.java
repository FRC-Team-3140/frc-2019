package frc.robot;

import frc.robot.commands.drivetrain.DriveAlongLine;
import frc.robot.commands.pneumatics.ShiftDown;
import frc.robot.commands.pneumatics.ShiftUp;
import frc.robot.libs.XboxController;

public final class OI {

	private static final int XBOX_PORT_1 = 0;

	private XboxController xbox1 = new XboxController(XBOX_PORT_1);

	public OI() {
		xbox1.leftBumper.whenPressed(new ShiftUp());
		xbox1.leftBumper.whenReleased(new ShiftDown());
		xbox1.rightBumper.whileHeld(new DriveAlongLine());
	}

	public void check() {
		xbox1.check();
	}

	public XboxController getXboxController(){
		return xbox1;
	}
}
