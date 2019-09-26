package frc.robot;

import frc.robot.commands.pneumatics.arm.*;
import frc.robot.commands.pneumatics.climber.*;
import frc.robot.commands.pneumatics.shifter.*;
import frc.robot.commands.pneumatics.forklift.*;
import frc.robot.commands.drivetrain.*;
import frc.robot.commands.elevator.*;
import frc.robot.commands.drivetrain.DriveAlongLine;
import frc.robot.commands.drivetrain.DrivePID;
import frc.robot.commands.drivetrain.DriveVoltage;
import frc.robot.libs.XboxController;

public final class OI {

	private static final int XBOX_PORT_1 = 0;
	private static final int XBOX_PORT_2 = 1;

	private static XboxController xbox1 = new XboxController(XBOX_PORT_1);
	private static XboxController xbox2 = new XboxController(XBOX_PORT_2);

	public OI() {
		xbox1.leftBumper.whenPressed(new ShiftUp());
		xbox1.leftBumper.whenReleased(new ShiftDown());
		//xbox1.start.whenPressed(new SwitchDrive(new DriveVoltage(), new DrivePID()));
		xbox1.rightBumper.whileHeld(new StopDrive());

		xbox2.leftBumper.whenPressed(new SwitchArm(new ArmClose(), new ArmOpen()));
		
		/*xbox2.a.whileHeld(new MoveLevel1());
		xbox2.b.whileHeld(new MoveLevel2());
		xbox2.y.whileHeld(new MoveLevel3());
		xbox2.x.whenPressed(new MoveToBottom());*/

		//xbox1.a.whenPressed(new SwitchClimb(new ClimbUp() , new ClimbDown()));
		/*xbox2.x.whenPressed(new ReleaseForklift());
		xbox2.x.whenReleased(new HoldForklift());*/
	}

	public void check() {
		xbox1.check();
		xbox2.check();
	}

	public static XboxController getXboxController(){
		return xbox1;
	}

	public static XboxController getXboxController2(){
		return xbox2;
	}
}
