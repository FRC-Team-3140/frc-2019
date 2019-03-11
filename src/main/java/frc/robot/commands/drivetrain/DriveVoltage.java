package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class DriveVoltage extends Command {
	private Robot robot;

	public DriveVoltage() {
		robot = Robot.getRobot();
		requires(robot.drivetrain);
	}

	@Override
	protected void execute() {
		Robot.getRobot().drivetrain.drive(robot.oi.getXboxController().getMainY(),
				robot.oi.getXboxController().getAltX());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
