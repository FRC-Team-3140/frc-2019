package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class ArcadeDrive extends Command {
	//private Robot robot;

	public ArcadeDrive() {
		//robot=Robot.getRobot();
		requires(Robot.drivetrain);
	}

	@Override
	protected void execute() {
		Robot.drivetrain.arcadeDrive(Robot.oi.getXboxController().getMainY(),
			Robot.oi.getXboxController().getAltX());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
