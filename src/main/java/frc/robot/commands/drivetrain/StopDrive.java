package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StopDrive extends Command {
	public StopDrive() {
		requires(Robot.getRobot().drivetrain);
	}

	@Override
	protected void execute() {
		Robot.getRobot().drivetrain.tankDrive(0, 0);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
