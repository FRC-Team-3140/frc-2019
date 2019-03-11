package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class DriveAlongLine extends Command {
	public DriveAlongLine() {
		requires(Robot.getRobot().drivetrain);
	}

	@Override
	protected void execute() {
		Robot.getRobot().drivetrain.driveAlongLine();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
