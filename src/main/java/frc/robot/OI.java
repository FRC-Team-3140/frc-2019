package frc.robot;

import frc.robot.commands.pneumatics.arm.ArmClose;
import frc.robot.commands.pneumatics.arm.ArmOpen;
import frc.robot.commands.pneumatics.climber.*;
import frc.robot.commands.pneumatics.shifter.*;
import frc.robot.commands.pneumatics.forklift.*;
import frc.robot.commands.drivetrain.SwitchDrive;
import frc.robot.commands.drivetrain.DriveAlongLine;
import frc.robot.commands.drivetrain.DrivePID;
import frc.robot.commands.drivetrain.DriveVoltage;
import frc.robot.libs.XboxController;

public final class OI {

	private static final int XBOX_PORT_1 = 0;
	private static final int XBOX_PORT_2 = 1;

	private XboxController xbox1 = new XboxController(XBOX_PORT_1);
	private XboxController xbox2 = new XboxController(XBOX_PORT_2);

	public OI() {
		xbox1.leftBumper.whenPressed(new ShiftUp());
		xbox1.leftBumper.whenReleased(new ShiftDown());
		xbox1.start.whenPressed(new SwitchDrive(new DriveVoltage(), new DrivePID()));

		xbox2.leftBumper.whenPressed(new ArmOpen());
		xbox2.rightBumper.whenReleased(new ArmClose());
		/*xbox2.rightBumper.whenPressed(new ClimbUp());
		xbox2.rightBumper.whenReleased(new ClimbDown());
		xbox2.x.whenPressed(new ReleaseForklift());
		xbox2.x.whenReleased(new HoldForklift());*/

		//xbox1.rightBumper.whileHeld(new DriveAlongLine());
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
