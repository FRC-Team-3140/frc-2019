package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class ArcadeDrive extends Command {
	private Robot robot;

	public ArcadeDrive() {
		robot=Robot.getRobot();
		requires(robot.drivetrain);
	}

	@Override
	protected void execute() {
		robot.drivetrain.arcadeDrive(robot.oi.getXboxController().getMainY(),
			robot.oi.getXboxController().getAltX());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
