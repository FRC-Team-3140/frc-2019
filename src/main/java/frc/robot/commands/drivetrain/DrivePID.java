package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class DrivePID extends Command {
	private Robot robot;

	public DrivePID() {
		robot = Robot.getRobot();
		requires(robot.drivetrain);
	}

	@Override
	protected void execute() {
		robot.drivetrain.driveVelocityJoystick(robot.oi.getXboxController().getMainY(),
				robot.oi.getXboxController().getAltX());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
