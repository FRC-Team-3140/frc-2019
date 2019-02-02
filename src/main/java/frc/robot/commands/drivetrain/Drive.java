package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class Drive extends Command {
	private Robot robot;

	public Drive() {
		robot=Robot.getRobot();
		requires(robot.drivetrain);
	}

	@Override
	protected void execute() {
		robot.drivetrain.drive(robot.oi.getXboxController().getMainY(),
			robot.oi.getXboxController().getAltX());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
