package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class SpinIn extends Command {
	public SpinIn() {
		requires(Robot.getRobot().intake);
	}

	@Override
	protected void execute() {
		Robot.getRobot().intake.spinIn();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
