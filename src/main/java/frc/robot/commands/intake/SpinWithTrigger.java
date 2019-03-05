package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SpinWithTrigger extends Command {
	public SpinWithTrigger() {
		requires(Robot.getRobot().intake);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.getRobot().intake.spinWithTriggers(Robot.getRobot().oi.getXboxController2().getLeftTrigger(),
				Robot.getRobot().oi.getXboxController2().getRightTrigger());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
	}
}
