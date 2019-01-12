package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArcadeDrive extends Command {
	public ArcadeDrive() {
		requires(Robot.drivetrain);
	}

	@Override
	protected void execute() {
		Robot.drivetrain.arcadeDrive(Robot.oi.getXboxController().getMainY(), Robot.oi.getXboxController().getAltX());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
