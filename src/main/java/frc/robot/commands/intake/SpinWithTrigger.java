package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class SpinWithTrigger extends Command {
	public SpinWithTrigger() {
		requires(Robot.getRobot().intake);
	}

	@Override
	protected void execute() {
		Robot.getRobot().intake.spinWithTriggers(Robot.getRobot().oi.getXboxController2().getLeftTrigger(),
				Robot.getRobot().oi.getXboxController2().getRightTrigger());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
